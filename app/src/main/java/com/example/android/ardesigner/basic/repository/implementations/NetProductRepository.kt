package com.example.android.ardesigner.basic.repository.implementations

import com.example.android.ardesigner.basic.data.ProductType
import com.example.android.ardesigner.basic.repository.interfaces.IProductRepository

class NetProductRepository : IProductRepository {

    override fun getAllProductsTypes(): List<ProductType> {

        return listOf(
                ProductType(0, "Leroy Merlin", "https://www.shtrih-m.ru/upload/iblock/b1f/leroymerlin.png"))
    }

}