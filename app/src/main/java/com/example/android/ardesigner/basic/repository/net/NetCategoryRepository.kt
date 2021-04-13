package com.example.android.ardesigner.basic.repository.net

import com.example.android.ardesigner.basic.api.ICategoryApi
import com.example.android.ardesigner.basic.data.Category
import com.example.android.ardesigner.basic.repository.interfaces.ICategoryRepository
import com.example.android.ardesigner.basic.repository.net.base.NetworkingRepository

class NetCategoryRepository : NetworkingRepository(), ICategoryRepository {

    private val api: ICategoryApi by lazy {
        ICategoryApi.create("http://84.201.189.12/")
    }

    override suspend fun getCategoriesList(): List<Category> {
        return safeApiCall({ api.getCategoriesList().await() }, "Error fetching categories")!!
    }
}