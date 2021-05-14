package com.arhome.repository.net

import androidx.lifecycle.LiveData
import com.arhome.api.ApiBuilder
import com.arhome.api.ICategoryApi
import com.arhome.data.Category
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.utils.repo.Resource
import com.arhome.repository.abstractions.NetworkBoundResource
import javax.inject.Inject

class CategoryNetRepository @Inject constructor(apiBuilder: ApiBuilder) :
        ICategoryRepository,
        NetRepository<ICategoryApi>(apiBuilder, ICategoryApi::class.java) {

    override fun getCategoriesList(): LiveData<Resource<List<Category>>> {

        return  NetworkBoundResource { api.getCategoriesList() }.asLiveData()

    }
}