package com.arhome.repository.interfaces

import com.arhome.data.Category

interface IProductRepository {

    fun getAllProductsTypes(): List<Category>

}