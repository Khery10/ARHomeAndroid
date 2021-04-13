package com.example.android.ardesigner.basic.camera.interfaces

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

interface ICameraProvider {
    fun getCameraCharacteristics(cameraManager: CameraManager): CameraInfo
}

data class CameraInfo(val cameraId: String, val outputFormat: Int)

