package com.example.android.ardesigner.basic.data

data class Category(
        override val id: Int,
        override val name: String,
        override val imageUrl: String) : ITextImageData