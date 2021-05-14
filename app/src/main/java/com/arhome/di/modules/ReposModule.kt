package com.arhome.di.modules

import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.net.CategoryNetRepository
import com.arhome.repository.net.ProductNetRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ReposModule {

    @Singleton
    @Binds
    abstract fun provideProductRepository(repo: ProductNetRepository): IProductRepository

    @Singleton
    @Binds
    abstract fun provideCategoryRepository(repo: CategoryNetRepository): ICategoryRepository

}