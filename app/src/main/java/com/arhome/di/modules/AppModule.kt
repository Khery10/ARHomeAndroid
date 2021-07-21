package com.arhome.di.modules

import android.graphics.ImageFormat
import android.hardware.camera2.CameraMetadata
import com.arhome.api.ApiBuilder
import com.arhome.api.ICategoryApi
import com.arhome.api.IProductApi
import com.arhome.api.ISegmentationApi
import com.arhome.camera.CameraProvider
import com.arhome.camera.interfaces.ICameraProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ReposModule::class,
    ServicesModule::class,
    ViewModelModule::class
])
class AppModule {

    private val apiBuilder = ApiBuilder("http://84.201.189.12:5000/")


    @Provides
    fun provideApiBuilder(): ApiBuilder = apiBuilder

    @Singleton
    @Provides
    fun provideCategoryApi(): ICategoryApi = apiBuilder.createLiveDataApi(ICategoryApi::class.java)

    @Singleton
    @Provides
    fun provideProductApi():IProductApi = apiBuilder.createLiveDataApi(IProductApi::class.java)

    @Singleton
    @Provides
    fun provideSegmentationApi(): ISegmentationApi = ApiBuilder("http://84.201.189.12:8000/").createApi(ISegmentationApi::class.java)

    @Singleton
    @Provides
    fun provideCameraProvider(): ICameraProvider = CameraProvider(CameraMetadata.LENS_FACING_BACK, ImageFormat.JPEG)
}