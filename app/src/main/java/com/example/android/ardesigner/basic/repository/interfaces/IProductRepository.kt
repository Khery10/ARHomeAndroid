package com.example.android.ardesigner.basic.repository.interfaces

import com.example.android.ardesigner.basic.data.ProductType

interface IProductRepository {

    fun getAllProductsTypes(): List<ProductType>

}