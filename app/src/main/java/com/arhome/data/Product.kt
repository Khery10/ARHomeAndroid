package com.arhome.data

import java.util.*

data class Product(
        val id: UUID,
        val name: String,
        val categoryId: UUID,
        val imageUrl: String)
