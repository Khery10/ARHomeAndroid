package com.arhome.di.modules

import android.graphics.ImageFormat
import android.hardware.camera2.CameraMetadata
import com.arhome.api.ApiBuilder
import com.arhome.camera.CameraProvider
import com.arhome.camera.interfaces.ICameraProvider
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.repository.net.ProductNetRepository
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.net.CategoryNetRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ReposModule::class,
    ViewModelModule::class
])
class AppModule {

    @Singleton
    @Provides
    fun provideApiBuilder(): ApiBuilder = ApiBuilder("http://84.201.189.12/")


    @Singleton
    @Provides
    fun provideCameraProvider(): ICameraProvider = CameraProvider(CameraMetadata.LENS_FACING_BACK, ImageFormat.JPEG)
}