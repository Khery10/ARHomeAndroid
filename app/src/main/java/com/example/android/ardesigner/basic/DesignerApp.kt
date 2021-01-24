package com.example.android.ardesigner.basic

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.android.ardesigner.basic.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class DesignerApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}