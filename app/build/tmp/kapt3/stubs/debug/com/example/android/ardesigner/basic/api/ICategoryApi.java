package com.example.android.ardesigner.basic.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/android/ardesigner/basic/api/ICategoryApi;", "", "getCategoriesList", "Lkotlinx/coroutines/Deferred;", "Lretrofit2/Response;", "", "Lcom/example/android/ardesigner/basic/data/Category;", "Companion", "app_debug"})
public abstract interface ICategoryApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.ardesigner.basic.api.ICategoryApi.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/Category/GetCategories")
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<java.util.List<com.example.android.ardesigner.basic.data.Category>>> getCategoriesList();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/android/ardesigner/basic/api/ICategoryApi$Companion;", "", "()V", "create", "Lcom/example/android/ardesigner/basic/api/ICategoryApi;", "baseUrl", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.android.ardesigner.basic.api.ICategoryApi create(@org.jetbrains.annotations.NotNull()
        java.lang.String baseUrl) {
            return null;
        }
    }
}