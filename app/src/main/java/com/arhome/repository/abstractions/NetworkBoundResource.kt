package com.arhome.repository.abstractions

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.arhome.utils.api.ApiErrorResponse
import com.arhome.utils.api.ApiResponse
import com.arhome.utils.api.ApiSuccessResponse
import com.arhome.utils.repo.Resource


class NetworkBoundResource<ResultType>(val call: () -> LiveData<ApiResponse<ResultType>>) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)
        fetchFromNetwork()
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork() {
        val apiResponse = createCall()

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)

            when (response) {
                is ApiSuccessResponse -> {
                    setValue(Resource.success(processResponse(response)))
                }
                is ApiErrorResponse -> {
                    onFetchFailed()
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<ResultType>) = response.body


    @MainThread
    protected fun createCall(): LiveData<ApiResponse<ResultType>> = call()
}