package com.arhome.di.modules

import com.arhome.segmentation.IImageRenderer
import com.arhome.segmentation.ISegmentationService
import com.arhome.segmentation.implementations.HttpSegmentationService
import com.arhome.segmentation.implementations.ImageRenderer
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServicesModule {

    @Singleton
    @Binds
    abstract fun provideSegmentationService(service: HttpSegmentationService): ISegmentationService


    @Singleton
    @Binds
    abstract fun provideImageRenderer(renderer: ImageRenderer): IImageRenderer

}