package com.arhome.segmentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color

class SegmentedImage(
        val imageContent: ByteArray,
        private val wallMaskContent: ByteArray,
        private val floorMaskContent: ByteArray) {

    private val wallMask: Bitmap by lazy {
        BitmapFactory.decodeByteArray(wallMaskContent, 0, wallMaskContent.size)
    }

    private val floorMask: Bitmap by lazy {
        BitmapFactory.decodeByteArray(floorMaskContent, 0, floorMaskContent.size)
    }

    fun isWall(x: Int, y: Int): Boolean {
        return checkPixel(wallMask, x, y)
    }

    fun isFloor(x: Int, y: Int): Boolean {
        return checkPixel(floorMask, x, y)
    }

    private fun checkPixel(map: Bitmap, x: Int, y: Int): Boolean {
        return map.getPixel(x, y) == Color.WHITE
    }
}