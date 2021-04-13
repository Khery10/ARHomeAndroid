package com.example.android.ardesigner.basic.repository.interfaces

import com.example.android.ardesigner.basic.data.Category

interface IProductRepository {

    fun getAllProductsTypes(): List<Category>

}