package com.arhome.api

import androidx.lifecycle.LiveData
import com.arhome.data.Product
import com.arhome.utils.api.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IProductApi {

    @GET("/api/Product/GetProducts")
    fun getProductsList(): LiveData<ApiResponse<List<Product>>>

    @GET("/api/Product/GetProductsByCategoryId")
    fun getProductsByCategoryId(@Query("categoryId") categoryId: Int): LiveData<ApiResponse<List<Product>>>

}