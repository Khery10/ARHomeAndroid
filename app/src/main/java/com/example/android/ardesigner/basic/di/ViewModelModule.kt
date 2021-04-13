package com.example.android.ardesigner.basic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.ardesigner.basic.viewModel.AppViewModelFactory
import com.example.android.ardesigner.basic.views.menu.categories.CategoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindProductsTypesViewMode(productsTypesViewModel: CategoryViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}