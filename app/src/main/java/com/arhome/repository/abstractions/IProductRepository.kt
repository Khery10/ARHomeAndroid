package com.arhome.repository.abstractions

import androidx.lifecycle.LiveData
import com.arhome.data.Category
import com.arhome.data.Product
import com.arhome.utils.repo.Resource
import java.util.*

interface IProductRepository {
    fun getAllProductsList(): LiveData<Resource<List<Product>>>

    fun getProductsByCategoryId(categoryId: UUID): LiveData<Resource<List<Product>>>
}