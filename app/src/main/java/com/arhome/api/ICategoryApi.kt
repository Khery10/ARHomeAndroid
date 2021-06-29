package com.arhome.api

import androidx.lifecycle.LiveData
import com.arhome.data.Category
import com.arhome.utils.api.ApiResponse
import com.arhome.utils.api.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import  retrofit2.http.*

interface ICategoryApi {

    @GET("/api/categories")
    fun getCategoriesList(): LiveData<ApiResponse<Array<Category>>>

    @GET("/api/categories/surfaceTypes/{surface}")
    fun getCategoriesBySurface(@Path("surface") surface: String): LiveData<ApiResponse<Array<Category>>>

}