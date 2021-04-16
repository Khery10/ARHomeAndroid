package com.example.android.utils.io

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import java.io.BufferedInputStream
import java.io.File

/** Utility function used to read input file into a byte array */
fun loadInputBuffer(filePath: String): ByteArray {
    val inputFile = File(filePath)
    return BufferedInputStream(inputFile.inputStream()).let { stream ->
        ByteArray(stream.available()).also {
            stream.read(it)
            stream.close()
        }
    }
}

/** Utility function used to decode a [Bitmap] from a byte array */
fun decodeBitmap(
        buffer: ByteArray,
        start: Int,
        length: Int,
        bitmapTransformation: Matrix,
        bitmapOptions: BitmapFactory.Options
): Bitmap {

    // Load bitmap from given buffer
    val bitmap = BitmapFactory.decodeByteArray(buffer, start, length, bitmapOptions)

    // Transform bitmap orientation using provided metadata
    return Bitmap.createBitmap(
            bitmap, 0, 0, bitmap.width, bitmap.height, bitmapTransformation, true)
}