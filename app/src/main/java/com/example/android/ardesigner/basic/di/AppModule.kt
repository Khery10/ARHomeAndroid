package com.example.android.ardesigner.basic.di

import com.example.android.ardesigner.basic.repository.implementations.NetProductRepository
import com.example.android.ardesigner.basic.repository.interfaces.IProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideProductRepository(): IProductRepository = NetProductRepository()

}