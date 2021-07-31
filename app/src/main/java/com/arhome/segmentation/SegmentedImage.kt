package com.arhome.segmentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Point
import androidx.core.graphics.get

class SegmentedImage(
        val imageContent: ByteArray,
        wallMaskContent: ByteArray,
        floorMaskContent: ByteArray) {

    val wallMask: Bitmap = BitmapFactory.decodeByteArray(wallMaskContent, 0, wallMaskContent.size)
    val floorMask: Bitmap = BitmapFactory.decodeByteArray(floorMaskContent, 0, floorMaskContent.size)

    val wallPixels: List<Point>
    val floorPixels: List<Point>

    init {
        var wallPoints = mutableListOf<Point>()
        var floorPoints = mutableListOf<Point>()

        for (i in 0 until wallMask.width) {
            for (j in 0 until wallMask.height) {
                if (checkPixel(wallMask, i, j))
                    wallPoints.add(Point(i, j))

                else if (checkPixel(floorMask, i, j))
                    floorPoints.add(Point(i, j))
            }
        }

        wallPixels = wallPoints
        floorPixels = floorPoints
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