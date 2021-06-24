package com.arhome.segmentation.implementations

import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arhome.api.ISegmentationApi
import com.arhome.api.dto.segmentation.SegmentationRequest
import com.arhome.api.dto.segmentation.SegmentationResponse
import com.arhome.segmentation.ISegmentationService
import com.arhome.segmentation.SegmentationImage
import com.arhome.segmentation.SegmentedImage
import com.arhome.utils.repo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HttpSegmentationService @Inject constructor(val api: ISegmentationApi) : ISegmentationService {

    private val TAG = HttpSegmentationService::class.java.simpleName

    override fun defineSegments(image: SegmentationImage): LiveData<Resource<SegmentedImage>> {

        val result = initResource()
        val request = SegmentationRequest(image.toBase64())

        api.defineSegments(request).enqueue(object : Callback<SegmentationResponse> {

            override fun onResponse(call: Call<SegmentationResponse>, response: Response<SegmentationResponse>) {
                processResponse(call, response, result)
            }

            override fun onFailure(call: Call<SegmentationResponse>, t: Throwable) {
                Log.e(TAG, t.message)
                result.postValue(Resource.error(t.message ?: "unknown error", null))
            }
        })

        return result
    }

    private fun initResource(): MutableLiveData<Resource<SegmentedImage>> {

        val result = MutableLiveData<Resource<SegmentedImage>>()
        result.postValue(Resource.loading(null))

        return result
    }


    private fun processResponse(
            call: Call<SegmentationResponse>,
            response: Response<SegmentationResponse>,
            data: MutableLiveData<Resource<SegmentedImage>>) {

        if (!response.isSuccessful) {
            Log.e(TAG, response.message())
            data.postValue(Resource.error(response.message(), null))
            return
        }

        val body = response.body()
        if (body == null) {
            val message = "Response body is null"
            Log.e(TAG, message)
            data.postValue(Resource.error(message, null))
            return
        }

        val segmentedImage = getSegmentedImage(body)
        data.postValue(Resource.success(segmentedImage))
    }

    private fun getSegmentedImage(response: SegmentationResponse): SegmentedImage {

        val content = Base64.decode(response.image, Base64.DEFAULT)
        return SegmentedImage(content)
    }
}