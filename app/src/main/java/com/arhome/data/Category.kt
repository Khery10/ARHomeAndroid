package com.arhome.data

import com.arhome.data.abstractions.ITextImageData
import java.util.*

data class Category(
        override val id: UUID,
        override val name: String,
        val description: String?,
        override val imageUrl: String?) : ITextImageData