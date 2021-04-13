package com.example.android.ardesigner.basic.di

import android.graphics.ImageDecoder
import android.graphics.ImageFormat
import android.hardware.camera2.CameraMetadata
import com.example.android.ardesigner.basic.camera.CameraProvider
import com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider
import com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository
import com.example.android.ardesigner.basic.repository.net.NetProductRepository
import com.example.android.ardesigner.basic.repository.interfaces.IProductRepository
import com.example.android.ardesigner.basic.repository.net.NetCategoryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideProductRepository(): IProductRepository = NetProductRepository()

    @Singleton
    @Provides
    fun provideCategoryRepository(): ICategoryRepository = NetCategoryRepository()

    @Singleton
    @Provides
    fun provideCameraProvider(): ICameraProvider = CameraProvider(CameraMetadata.LENS_FACING_BACK, ImageFormat.JPEG)
}