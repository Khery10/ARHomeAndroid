package com.arhome.api

import android.icu.util.TimeUnit
import com.arhome.utils.api.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiBuilder(val baseUrl: String) {

    fun <TApi> createLiveDataApi(classApi: Class<TApi>): TApi {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(classApi)
    }

    fun <TApi> createApi(classApi: Class<TApi>): TApi {

        val client = OkHttpClient.Builder()
                .connectTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(120, java.util.concurrent.TimeUnit.SECONDS)
                .build()


        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(classApi)
    }
}