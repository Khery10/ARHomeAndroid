package com.arhome.api

import com.arhome.utils.api.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder(val baseUrl: String) {

    fun <TApi> createApi(classApi: Class<TApi>): TApi {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(classApi)
    }
}