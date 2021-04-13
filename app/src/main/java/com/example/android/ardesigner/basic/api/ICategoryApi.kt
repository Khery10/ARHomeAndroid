package com.example.android.ardesigner.basic.api

import com.example.android.ardesigner.basic.data.Category
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import  retrofit2.http.*

interface ICategoryApi {

    @GET("/api/Category/GetCategories")
    fun getCategoriesList() : Deferred<Response<List<Category>>>

    companion object {
        fun create(baseUrl: String): ICategoryApi {

            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ICategoryApi::class.java)
        }
    }
}