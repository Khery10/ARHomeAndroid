package com.arhome.api

import androidx.lifecycle.LiveData
import com.arhome.data.Product
import com.arhome.utils.api.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface IProductApi {

    @GET("/api/products")
    fun getProductsList(): LiveData<ApiResponse<List<Product>>>

    @GET("/api/products/getByCategory")
    fun getProductsByCategoryId(@Query("categoryId") categoryId: UUID): LiveData<ApiResponse<List<Product>>>

}