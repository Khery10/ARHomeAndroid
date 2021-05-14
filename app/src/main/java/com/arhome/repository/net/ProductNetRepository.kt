package com.arhome.repository.net

import androidx.lifecycle.LiveData
import com.arhome.api.ApiBuilder
import com.arhome.api.IProductApi
import com.arhome.data.Category
import com.arhome.data.Product
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.repository.abstractions.NetworkBoundResource
import com.arhome.utils.repo.Resource
import javax.inject.Inject

class ProductNetRepository @Inject constructor(apiBuilder: ApiBuilder) :
        IProductRepository,
        NetRepository<IProductApi>(apiBuilder, IProductApi::class.java) {

    override fun getAllProductsList(): LiveData<Resource<List<Product>>> =
            NetworkBoundResource { api.getProductsList() }.asLiveData()

    override fun getProductsByCategoryId(categoryId: Int): LiveData<Resource<List<Product>>> =
            NetworkBoundResource { api.getProductsByCategoryId(categoryId) }.asLiveData()
}