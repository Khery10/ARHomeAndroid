package com.arhome.repository.net

import com.arhome.api.ApiBuilder

abstract class NetRepository<TApi>(val apiBuilder: ApiBuilder, val classApi: Class<TApi>) {

    protected val api: TApi by lazy {
        apiBuilder.createApi(classApi)
    }

}