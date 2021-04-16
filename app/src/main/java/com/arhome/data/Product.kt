package com.arhome.data

import java.util.*

data class Product(
        val id: UUID,
        val name: String,
        val type: Category,
        val retailer: Retailer,
        val imgUrl: String)
