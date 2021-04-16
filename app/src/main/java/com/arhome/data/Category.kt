package com.arhome.data

import com.arhome.data.interfaces.ITextImageData

data class Category(
        override val id: Int,
        override val name: String,
        override val imageUrl: String) : ITextImageData