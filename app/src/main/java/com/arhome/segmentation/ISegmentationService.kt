package com.arhome.segmentation

import androidx.lifecycle.LiveData
import com.arhome.api.dto.segmentation.SegmentationResponse
import com.arhome.utils.repo.Resource
import retrofit2.Call

interface ISegmentationService {

    fun defineSegments(image: SegmentationImage): LiveData<Resource<SegmentedImage>>

}