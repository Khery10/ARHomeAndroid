package com.arhome.segmentation.implementations

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.get
import com.arhome.segmentation.IImageRenderer
import javax.inject.Inject

class ImageRenderer @Inject constructor() : IImageRenderer {

    override fun applyColor(image: Bitmap, mask: Bitmap, color: Int): Bitmap {

        if (image.height != mask.height || image.width != mask.width)
            throw IllegalArgumentException("The size of the picture and the mask are different")

        for (i in 0 until mask.width) {
            for (j in 0 until mask.height) {
                if (mask.get(i, j) == Color.WHITE) {
                    image.setPixel(i, j, color)
                }
            }
        }

        return image
    }

}