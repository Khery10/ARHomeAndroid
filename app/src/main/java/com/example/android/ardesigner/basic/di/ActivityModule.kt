package com.example.android.ardesigner.basic.di

import com.example.android.ardesigner.basic.views.CameraActivity
import com.example.android.ardesigner.basic.views.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}