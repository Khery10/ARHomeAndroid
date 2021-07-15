package com.arhome.views.segmentation

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.arhome.segmentation.ISegmentationService
import com.arhome.segmentation.SegmentationImage
import com.arhome.segmentation.SegmentedImage
import com.arhome.utils.repo.Resource
import javax.inject.Inject

class SegmentationViewModel @Inject constructor(val service: ISegmentationService) : ViewModel() {

    val imagePath = MutableLiveData<String>()
    val data = MediatorLiveData<Resource<SegmentedImage>>()

    init {
        data.postValue(Resource.loading(null))
    }

    fun defineImage(imagePath: String) {

        val segmentationSource = service.defineSegments(SegmentationImage(imagePath))

        data.addSource(segmentationSource) {
            data.postValue(it)
        }

        this.imagePath.postValue(imagePath)
    }
}