package com.arhome.di

import com.arhome.views.CameraActivity
import com.arhome.views.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity


    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeCameraActivity(): CameraActivity
}