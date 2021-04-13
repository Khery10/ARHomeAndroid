package com.example.android.ardesigner.basic.repository.net

import com.example.android.ardesigner.basic.data.Category
import com.example.android.ardesigner.basic.repository.interfaces.IProductRepository

class NetProductRepository : IProductRepository {

    override fun getAllProductsTypes(): List<Category> {

        return listOf(
                Category(0, "Leroy Merlin", "https://www.shtrih-m.ru/upload/iblock/b1f/leroymerlin.png"))
    }

}