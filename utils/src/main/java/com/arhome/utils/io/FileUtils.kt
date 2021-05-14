package com.arhome.utils.io

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*


fun getImageName(extension: String): String {
    val sdf = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
    return "IMG_${sdf.format(Date())}.$extension"
}

/**
 * Create a [File] named a using formatted timestamp with the current date and time.
 */
fun createImageFile(context: Context, extension: String): File {
    return File(context.filesDir, getImageName(extension))
}

fun createImageFile(parent: File, extension: String): File {
    return File(parent, getImageName(extension))
}


fun saveJpgImageToDCIM(context: Context, bitmap: Bitmap) {

    var fos: OutputStream? = null
    var imagePath: String? = null

    //For devices running android >= Q
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        context?.contentResolver?.also { resolver ->

            val contentValues = ContentValues().apply {

                put(MediaStore.MediaColumns.DISPLAY_NAME, getImageName("jpg"))
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            }

            val imageUri: Uri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)!!

            imagePath = imageUri.path
            fos = imageUri.let { resolver.openOutputStream(it) }
        }
    } else {

        //These for devices running on android < Q
        val imagesDir =
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera")

        val image = createImageFile(imagesDir, "jpg")
        imagePath = image.path
        fos = FileOutputStream(image)
    }

    fos?.use {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
    }

    MediaScannerConnection.scanFile(context, arrayOf(imagePath), arrayOf("image/jpeg"), null)
}


fun saveJpgImageToDCIM(context: Context, sourceImage: File) {

    var targetImage: File? = null

    //For devices running android >= Q
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        context?.contentResolver?.also { resolver ->

            val contentValues = ContentValues().apply {

                put(MediaStore.MediaColumns.DISPLAY_NAME, getImageName("jpg"))
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            }

            val imageUri: Uri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)!!

            targetImage = File(imageUri.path)
        }
    } else {

        //These for devices running on android < Q
        val imagesDir =
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera")

        targetImage = createImageFile(imagesDir, "jpg")
    }

    sourceImage.copyTo(targetImage!!)
    MediaScannerConnection.scanFile(context, arrayOf(targetImage!!.path), arrayOf("image/jpeg"), null)
}

