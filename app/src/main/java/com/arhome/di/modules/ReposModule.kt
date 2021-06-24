package com.arhome.di.modules

import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.http.HttpCategoriesRepository
import com.arhome.repository.http.HttpProductsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ReposModule {

    @Singleton
    @Binds
    abstract fun provideProductRepository(repo: HttpProductsRepository): IProductRepository

    @Singleton
    @Binds
    abstract fun provideCategoryRepository(repo: HttpCategoriesRepository): ICategoryRepository

}