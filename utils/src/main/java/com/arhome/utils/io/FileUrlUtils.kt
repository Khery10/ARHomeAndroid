package com.arhome.utils.io

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

class FileUrlUtils {
    companion object {
        fun getRealPathFromURI(context: Context, contentUri: Uri): String {

            var cursor: Cursor? = null
            return try {
                val proj = arrayOf(MediaStore.Images.Media.DATA)
                cursor = context.contentResolver.query(contentUri, proj, null, null, null)!!
                val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor.moveToFirst()
                cursor.getString(column_index)
            } finally {
                if (cursor != null) {
                    cursor.close()
                }
            }
        }
    }
}