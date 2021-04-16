package com.arhome.repository.net

import com.arhome.data.Category
import com.arhome.repository.interfaces.IProductRepository

class NetProductRepository : IProductRepository {

    override fun getAllProductsTypes(): List<Category> {

        return listOf(
                Category(0, "Leroy Merlin", "https://www.shtrih-m.ru/upload/iblock/b1f/leroymerlin.png"))
    }

}