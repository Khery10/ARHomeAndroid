package com.arhome.api.dto.segmentation

data class SegmentationResponse(
        val wall: String,
        val floor: String,
        val image: String)