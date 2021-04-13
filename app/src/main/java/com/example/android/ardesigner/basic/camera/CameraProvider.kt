package com.example.android.ardesigner.basic.camera

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import com.example.android.ardesigner.basic.camera.interfaces.*

class CameraProvider(val orientation: Int, val outpuFormat: Int) : ICameraProvider {

    override fun getCameraCharacteristics(cameraManager: CameraManager): CameraInfo {

        val cameraId = cameraManager.cameraIdList
                .firstOrNull { id -> checkCharacteristic(cameraManager.getCameraCharacteristics(id))}
                ?: throw Error("The required camera characteristics were not found")

        return CameraInfo(cameraId, outpuFormat)
    }

    private fun checkCharacteristic(characteristics: CameraCharacteristics): Boolean {
        return characteristics.get(CameraCharacteristics.LENS_FACING) == orientation
                && characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)!!
                .outputFormats.contains(outpuFormat)
    }
}