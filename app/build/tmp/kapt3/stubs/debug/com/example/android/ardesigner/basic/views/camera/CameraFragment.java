package com.example.android.ardesigner.basic.views.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0005\u00a2\u0006\u0002\u0010\u0003J3\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u000b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010<J\b\u0010=\u001a\u00020>H\u0002J&\u0010?\u001a\u0004\u0018\u00010/2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020GH\u0016J\u001a\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010EH\u0017J-\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020N2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0012H\u0083@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010OJ\u0019\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010TJ\u0011\u0010U\u001a\u00020SH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/example/android/ardesigner/basic/views/camera/CameraFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/android/ardesigner/basic/di/Injectable;", "()V", "animationTask", "Ljava/lang/Runnable;", "getAnimationTask", "()Ljava/lang/Runnable;", "animationTask$delegate", "Lkotlin/Lazy;", "camera", "Landroid/hardware/camera2/CameraDevice;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getCameraCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "cameraCharacteristics$delegate", "cameraHandler", "Landroid/os/Handler;", "cameraInfo", "Lcom/example/android/ardesigner/basic/camera/interfaces/CameraInfo;", "getCameraInfo", "()Lcom/example/android/ardesigner/basic/camera/interfaces/CameraInfo;", "cameraInfo$delegate", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager", "()Landroid/hardware/camera2/CameraManager;", "cameraManager$delegate", "cameraProvider", "Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;", "getCameraProvider", "()Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;", "setCameraProvider", "(Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;)V", "cameraThread", "Landroid/os/HandlerThread;", "imageReader", "Landroid/media/ImageReader;", "imageReaderHandler", "imageReaderThread", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navController$delegate", "overlay", "Landroid/view/View;", "relativeOrientation", "Lcom/example/android/camera/utils/OrientationLiveData;", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "viewFinder", "Lcom/example/android/camera/utils/AutoFitSurfaceView;", "createCaptureSession", "device", "targets", "", "Landroid/view/Surface;", "handler", "(Landroid/hardware/camera2/CameraDevice;Ljava/util/List;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeCamera", "Lkotlinx/coroutines/Job;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onStop", "onViewCreated", "view", "openCamera", "manager", "cameraId", "", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Landroid/os/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveResult", "Ljava/io/File;", "result", "Lcom/example/android/ardesigner/basic/views/camera/CameraFragment$Companion$CombinedCaptureResult;", "(Lcom/example/android/ardesigner/basic/views/camera/CameraFragment$Companion$CombinedCaptureResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takePhoto", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class CameraFragment extends androidx.fragment.app.Fragment implements com.example.android.ardesigner.basic.di.Injectable {
    @javax.inject.Inject()
    public com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider cameraProvider;
    
    /**
     * Host's navigation controller
     */
    private final kotlin.Lazy navController$delegate = null;
    
    /**
     * Detects, characterizes, and connects to a CameraDevice (used for all camera operations)
     */
    private final kotlin.Lazy cameraManager$delegate = null;
    private final kotlin.Lazy cameraInfo$delegate = null;
    
    /**
     * [CameraCharacteristics] corresponding to the provided Camera ID
     */
    private final kotlin.Lazy cameraCharacteristics$delegate = null;
    
    /**
     * Readers used as buffers for camera still shots
     */
    private android.media.ImageReader imageReader;
    
    /**
     * [HandlerThread] where all camera operations run
     */
    private final android.os.HandlerThread cameraThread = null;
    
    /**
     * [Handler] corresponding to [cameraThread]
     */
    private final android.os.Handler cameraHandler = null;
    
    /**
     * Performs recording animation of flashing screen
     */
    private final kotlin.Lazy animationTask$delegate = null;
    
    /**
     * [HandlerThread] where all buffer reading operations run
     */
    private final android.os.HandlerThread imageReaderThread = null;
    
    /**
     * [Handler] corresponding to [imageReaderThread]
     */
    private final android.os.Handler imageReaderHandler = null;
    
    /**
     * Where the camera preview is displayed
     */
    private com.example.android.camera.utils.AutoFitSurfaceView viewFinder;
    
    /**
     * Overlay on top of the camera preview
     */
    private android.view.View overlay;
    
    /**
     * The [CameraDevice] that will be opened in this fragment
     */
    private android.hardware.camera2.CameraDevice camera;
    
    /**
     * Internal reference to the ongoing [CameraCaptureSession] configured with our parameters
     */
    private android.hardware.camera2.CameraCaptureSession session;
    
    /**
     * Live data listener for changes in the device orientation relative to the camera
     */
    private com.example.android.camera.utils.OrientationLiveData relativeOrientation;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.ardesigner.basic.views.camera.CameraFragment.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    /**
     * Maximum number of images that will be held in the reader's buffer
     */
    private static final int IMAGE_BUFFER_SIZE = 3;
    
    /**
     * Maximum time allowed to wait for the result of an image capture
     */
    private static final long IMAGE_CAPTURE_TIMEOUT_MILLIS = 5000L;
    private java.util.HashMap _$_findViewCache;
    
    public CameraFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider getCameraProvider() {
        return null;
    }
    
    public final void setCameraProvider(@org.jetbrains.annotations.NotNull()
    com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider p0) {
    }
    
    /**
     * Host's navigation controller
     */
    private final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    /**
     * Detects, characterizes, and connects to a CameraDevice (used for all camera operations)
     */
    private final android.hardware.camera2.CameraManager getCameraManager() {
        return null;
    }
    
    private final com.example.android.ardesigner.basic.camera.interfaces.CameraInfo getCameraInfo() {
        return null;
    }
    
    /**
     * [CameraCharacteristics] corresponding to the provided Camera ID
     */
    private final android.hardware.camera2.CameraCharacteristics getCameraCharacteristics() {
        return null;
    }
    
    /**
     * Performs recording animation of flashing screen
     */
    private final java.lang.Runnable getAnimationTask() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Begin all camera operations in a coroutine in the main thread. This function:
     * - Opens the camera
     * - Configures the camera session
     * - Starts the preview by dispatching a repeating capture request
     * - Sets up the still image capture listeners
     */
    private final kotlinx.coroutines.Job initializeCamera() {
        return null;
    }
    
    /**
     * Opens the camera and returns the opened device (as the result of the suspend coroutine)
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final java.lang.Object openCamera(android.hardware.camera2.CameraManager manager, java.lang.String cameraId, android.os.Handler handler, kotlin.coroutines.Continuation<? super android.hardware.camera2.CameraDevice> p3) {
        return null;
    }
    
    /**
     * Starts a [CameraCaptureSession] and returns the configured session (as the result of the
     * suspend coroutine
     */
    private final java.lang.Object createCaptureSession(android.hardware.camera2.CameraDevice device, java.util.List<? extends android.view.Surface> targets, android.os.Handler handler, kotlin.coroutines.Continuation<? super android.hardware.camera2.CameraCaptureSession> p3) {
        return null;
    }
    
    /**
     * Helper function used to capture a still image using the [CameraDevice.TEMPLATE_STILL_CAPTURE]
     * template. It performs synchronization between the [CaptureResult] and the [Image] resulting
     * from the single capture, and outputs a [CombinedCaptureResult] object.
     */
    private final java.lang.Object takePhoto(kotlin.coroutines.Continuation<? super com.example.android.ardesigner.basic.views.camera.CameraFragment.Companion.CombinedCaptureResult> p0) {
        return null;
    }
    
    /**
     * Helper function used to save a [CombinedCaptureResult] into a [File]
     */
    private final java.lang.Object saveResult(com.example.android.ardesigner.basic.views.camera.CameraFragment.Companion.CombinedCaptureResult result, kotlin.coroutines.Continuation<? super java.io.File> p1) {
        return null;
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/android/ardesigner/basic/views/camera/CameraFragment$Companion;", "", "()V", "IMAGE_BUFFER_SIZE", "", "IMAGE_CAPTURE_TIMEOUT_MILLIS", "", "TAG", "", "createFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "extension", "CombinedCaptureResult", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Create a [File] named a using formatted timestamp with the current date and time.
         *
         * @return [File] created.
         */
        private final java.io.File createFile(android.content.Context context, java.lang.String extension) {
            return null;
        }
        
        /**
         * Helper data class used to hold capture metadata with their associated image
         */
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/example/android/ardesigner/basic/views/camera/CameraFragment$Companion$CombinedCaptureResult;", "Ljava/io/Closeable;", "image", "Landroid/media/Image;", "metadata", "Landroid/hardware/camera2/CaptureResult;", "orientation", "", "format", "(Landroid/media/Image;Landroid/hardware/camera2/CaptureResult;II)V", "getFormat", "()I", "getImage", "()Landroid/media/Image;", "getMetadata", "()Landroid/hardware/camera2/CaptureResult;", "getOrientation", "close", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
        public static final class CombinedCaptureResult implements java.io.Closeable {
            @org.jetbrains.annotations.NotNull()
            private final android.media.Image image = null;
            @org.jetbrains.annotations.NotNull()
            private final android.hardware.camera2.CaptureResult metadata = null;
            private final int orientation = 0;
            private final int format = 0;
            
            /**
             * Helper data class used to hold capture metadata with their associated image
             */
            @org.jetbrains.annotations.NotNull()
            public final com.example.android.ardesigner.basic.views.camera.CameraFragment.Companion.CombinedCaptureResult copy(@org.jetbrains.annotations.NotNull()
            android.media.Image image, @org.jetbrains.annotations.NotNull()
            android.hardware.camera2.CaptureResult metadata, int orientation, int format) {
                return null;
            }
            
            /**
             * Helper data class used to hold capture metadata with their associated image
             */
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
            
            /**
             * Helper data class used to hold capture metadata with their associated image
             */
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            /**
             * Helper data class used to hold capture metadata with their associated image
             */
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public CombinedCaptureResult(@org.jetbrains.annotations.NotNull()
            android.media.Image image, @org.jetbrains.annotations.NotNull()
            android.hardware.camera2.CaptureResult metadata, int orientation, int format) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.media.Image component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.media.Image getImage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.hardware.camera2.CaptureResult component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.hardware.camera2.CaptureResult getMetadata() {
                return null;
            }
            
            public final int component3() {
                return 0;
            }
            
            public final int getOrientation() {
                return 0;
            }
            
            public final int component4() {
                return 0;
            }
            
            public final int getFormat() {
                return 0;
            }
            
            @java.lang.Override()
            public void close() {
            }
        }
    }
}