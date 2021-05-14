package com.arhome.api

import androidx.lifecycle.LiveData
import com.arhome.data.Category
import com.arhome.utils.api.ApiResponse
import com.arhome.utils.api.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import  retrofit2.http.*

interface ICategoryApi {

    @GET("/api/Category/GetCategories")
    fun getCategoriesList() : LiveData<ApiResponse<List<Category>>>

}