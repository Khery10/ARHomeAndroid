package com.arhome.repository.http

import androidx.lifecycle.LiveData
import com.arhome.api.ICategoryApi
import com.arhome.data.Category
import com.arhome.data.SurfaceType
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.utils.repo.Resource
import com.arhome.repository.abstractions.NetworkBoundResource
import javax.inject.Inject

class HttpCategoriesRepository @Inject constructor(val api: ICategoryApi) : ICategoryRepository {

    override fun getCategoriesList(): LiveData<Resource<Array<Category>>> {
        return NetworkBoundResource { api.getCategoriesList() }.asLiveData()
    }

    override fun getCategoriesBySurface(surface: SurfaceType): LiveData<Resource<Array<Category>>> {
        return NetworkBoundResource { api.getCategoriesBySurface(surface.name) }.asLiveData()
    }
}