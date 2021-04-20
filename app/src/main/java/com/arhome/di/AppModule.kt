package com.arhome.di

import android.graphics.ImageFormat
import android.hardware.camera2.CameraMetadata
import com.arhome.camera.CameraProvider
import com.arhome.camera.interfaces.ICameraProvider
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.repository.net.NetProductRepository
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.net.NetCategoryRepository
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