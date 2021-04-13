package com.example.android.ardesigner.basic.di

import com.example.android.ardesigner.basic.views.camera.CameraFragment
import com.example.android.ardesigner.basic.views.menu.MenuFragment
import com.example.android.ardesigner.basic.views.menu.categories.CategoryFragment
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