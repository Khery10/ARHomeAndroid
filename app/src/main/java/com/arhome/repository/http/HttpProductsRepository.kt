package com.arhome.repository.http

import androidx.lifecycle.LiveData
import com.arhome.api.IProductApi
import com.arhome.data.Product
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.abstractions.NetworkBoundResource
import com.arhome.utils.repo.Resource
import java.util.*
import javax.inject.Inject

class HttpProductsRepository @Inject constructor(val api: IProductApi) : IProductRepository {

    override fun getAllProductsList(): LiveData<Resource<List<Product>>> {
        return NetworkBoundResource { api.getProductsList() }.asLiveData()
    }

    override fun getProductsByCategoryId(categoryId: UUID): LiveData<Resource<List<Product>>> {
        return NetworkBoundResource { api.getProductsByCategoryId(categoryId) }.asLiveData()
    }
}