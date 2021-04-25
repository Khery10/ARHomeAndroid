package com.arhome.utils.io

import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


/**
 * Create a [File] named a using formatted timestamp with the current date and time.
 */
fun createFile(context: Context, extension: String): File {
    val sdf = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US)
    return File(context.filesDir, "IMG_${sdf.format(Date())}.$extension")
}