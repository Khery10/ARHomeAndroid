package com.arhome.di.modules

import com.arhome.segmentation.ISegmentationService
import com.arhome.segmentation.implementations.HttpSegmentationService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServicesModule {

    @Singleton
    @Binds
    abstract fun provideProductRepository(repo: HttpSegmentationService): ISegmentationService

}