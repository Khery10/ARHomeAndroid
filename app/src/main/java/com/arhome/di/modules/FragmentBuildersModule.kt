package com.arhome.di.modules

import com.arhome.views.camera.CameraFragment
import com.arhome.views.menu.MenuFragment
import com.arhome.views.menu.categories.CategoryFragment
import com.arhome.views.menu.products.ProductsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeProductsFragment(): ProductsFragment

    @ContributesAndroidInjector
    abstract fun contributeCameraFragment(): CameraFragment
}