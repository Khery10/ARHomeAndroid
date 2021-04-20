package com.arhome.repository.net

import androidx.lifecycle.LiveData
import com.arhome.api.ICategoryApi
import com.arhome.data.Category
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.utils.repo.Resource
import com.arhome.repository.abstractions.NetworkBoundResource

class NetCategoryRepository : ICategoryRepository {

    private val api: ICategoryApi by lazy {
        ICategoryApi.create("http://84.201.189.12/")
    }

    override fun getCategoriesList(): LiveData<Resource<List<Category>>> {

        return object : NetworkBoundResource<List<Category>>() {

            override fun createCall() = api.getCategoriesList()

        }.asLiveData()
    }
}