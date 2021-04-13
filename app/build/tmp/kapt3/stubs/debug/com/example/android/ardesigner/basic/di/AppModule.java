package com.example.android.ardesigner.basic.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/android/ardesigner/basic/di/AppModule;", "", "()V", "provideCameraProvider", "Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;", "provideCategoryRepository", "Lcom/example/android/ardesigner/basic/repository/interfaces/ICategoryRepository;", "provideProductRepository", "Lcom/example/android/ardesigner/basic/repository/interfaces/IProductRepository;", "app_debug"})
@dagger.Module(includes = {com.example.android.ardesigner.basic.di.ViewModelModule.class})
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.android.ardesigner.basic.repository.interfaces.IProductRepository provideProductRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository provideCategoryRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.android.ardesigner.basic.camera.interfaces.ICameraProvider provideCameraProvider() {
        return null;
    }
}