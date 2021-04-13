package com.example.android.ardesigner.basic.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/example/android/ardesigner/basic/data/ITextImageData;", "", "id", "", "getId", "()I", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "name", "getName", "app_debug"})
public abstract interface ITextImageData {
    
    public abstract int getId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getImageUrl();
}