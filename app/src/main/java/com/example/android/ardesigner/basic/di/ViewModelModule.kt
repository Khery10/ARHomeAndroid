package com.example.android.ardesigner.basic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.ardesigner.basic.viewModel.AppViewModelFactory
import com.example.android.ardesigner.basic.views.menu.productsTypes.ProductsTypesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductsTypesViewModel::class)
    abstract fun bindProductsTypesViewMode(productsTypesViewModel: ProductsTypesViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}