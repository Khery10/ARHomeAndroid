package com.example.android.ardesigner.basic.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/example/android/ardesigner/basic/camera/CameraProvider;", "Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;", "orientation", "", "outpuFormat", "(II)V", "getOrientation", "()I", "getOutpuFormat", "checkCharacteristic", "", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getCameraCharacteristics", "Lcom/example/android/ardesigner/basic/camera/interfaces/CameraInfo;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "app_debug"})
public final class CameraProvider implements com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider {
    private final int orientation = 0;
    private final int outpuFormat = 0;
    
    public CameraProvider(int orientation, int outpuFormat) {
        super();
    }
    
    public final int getOrientation() {
        return 0;
    }
    
    public final int getOutpuFormat() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.android.ardesigner.basic.camera.interfaces.CameraInfo getCameraCharacteristics(@org.jetbrains.annotations.NotNull()
    android.hardware.camera2.CameraManager cameraManager) {
        return null;
    }
    
    private final boolean checkCharacteristic(android.hardware.camera2.CameraCharacteristics characteristics) {
        return false;
    }
}