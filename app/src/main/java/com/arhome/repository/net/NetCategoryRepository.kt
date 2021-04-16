package com.arhome.repository.net

import com.arhome.api.ICategoryApi
import com.arhome.data.Category
import com.arhome.repository.interfaces.ICategoryRepository
import com.arhome.repository.net.base.NetworkingRepository

class NetCategoryRepository : NetworkingRepository(), ICategoryRepository {

    private val api: ICategoryApi by lazy {
        ICategoryApi.create("http://84.201.189.12/")
    }

    override suspend fun getCategoriesList(): List<Category> {
        return safeApiCall({ api.getCategoriesList().await() }, "Error fetching categories")!!
    }
}