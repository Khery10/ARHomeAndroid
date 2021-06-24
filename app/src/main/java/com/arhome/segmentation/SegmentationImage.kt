package com.arhome.segmentation

import android.graphics.ImageFormat
import android.util.Base64
import java.io.File

class SegmentationImage(val imagePath: String) {

    private val imageFile: File by lazy { File(imagePath) }

    fun toBase64(): String {
        return Base64.encodeToString(imageFile.readBytes(), Base64.DEFAULT)
    }

}