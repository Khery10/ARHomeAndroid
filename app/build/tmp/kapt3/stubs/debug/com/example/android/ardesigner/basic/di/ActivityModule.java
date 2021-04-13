package com.example.android.ardesigner.basic.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/android/ardesigner/basic/di/ActivityModule;", "", "()V", "contributeCameraActivity", "Lcom/example/android/ardesigner/basic/views/CameraActivity;", "contributeMainActivity", "Lcom/example/android/ardesigner/basic/views/MainActivity;", "app_debug"})
@dagger.Module()
public abstract class ActivityModule {
    
    public ActivityModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector(modules = {com.example.android.ardesigner.basic.di.FragmentBuildersModule.class})
    public abstract com.example.android.ardesigner.basic.views.MainActivity contributeMainActivity();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector(modules = {com.example.android.ardesigner.basic.di.FragmentBuildersModule.class})
    public abstract com.example.android.ardesigner.basic.views.CameraActivity contributeCameraActivity();
}