package com.arhome.repository.abstractions

import com.arhome.data.Category

interface IProductRepository {

    fun getAllProductsTypes(): List<Category>

}