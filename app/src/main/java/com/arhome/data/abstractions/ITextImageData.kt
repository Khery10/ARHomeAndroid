package com.arhome.data.abstractions

import java.util.*

interface ITextImageData {
    val id: UUID
    val name: String
    val imageUrl: String?
}