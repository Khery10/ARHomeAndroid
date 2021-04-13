package com.example.android.ardesigner.basic.views.menu.categories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/android/ardesigner/basic/views/menu/categories/CategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/android/ardesigner/basic/repository/interfaces/ICategoryRepository;", "(Lcom/example/android/ardesigner/basic/repository/interfaces/ICategoryRepository;)V", "categories", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/android/ardesigner/basic/data/Category;", "getCategories", "()Landroidx/lifecycle/MutableLiveData;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "getRepository", "()Lcom/example/android/ardesigner/basic/repository/interfaces/ICategoryRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "fetchCategories", "", "app_debug"})
public final class CategoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.android.ardesigner.basic.data.Category>> categories = null;
    private final kotlinx.coroutines.CompletableJob parentJob = null;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    @javax.inject.Inject()
    public CategoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.android.ardesigner.basic.data.Category>> getCategories() {
        return null;
    }
    
    private final kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    public final void fetchCategories() {
    }
}