package com.arhome.segmentation

import android.graphics.Bitmap
import android.graphics.Color

interface IImageRenderer {

    fun applyColor(image: Bitmap, mask: Bitmap, color: Int) : Bitmap

}