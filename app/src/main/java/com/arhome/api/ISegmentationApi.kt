package com.arhome.api

import com.arhome.api.dto.segmentation.SegmentationRequest
import com.arhome.api.dto.segmentation.SegmentationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ISegmentationApi {

    @POST("/api/segmentation/defineSegments/")
    fun defineSegments(@Body request: SegmentationRequest) : Call<SegmentationResponse>

}