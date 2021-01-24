package com.example.android.ardesigner.basic.di

import com.example.android.ardesigner.basic.views.menu.MenuFragment
import com.example.android.ardesigner.basic.views.menu.productsTypes.ProductsTypesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeProductsTypesFragment(): ProductsTypesFragment
}