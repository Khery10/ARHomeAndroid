package com.arhome.di

import com.arhome.views.camera.CameraFragment
import com.arhome.views.menu.MenuFragment
import com.arhome.views.menu.categories.CategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeCameraFragment(): CameraFragment
}