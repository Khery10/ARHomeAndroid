package com.arhome.data

import com.arhome.data.abstractions.ITextImageData

data class Category(
        override val id: Int,
        override val name: String,
        override val imageUrl: String) : ITextImageData