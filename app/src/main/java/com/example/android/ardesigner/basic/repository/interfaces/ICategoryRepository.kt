package com.example.android.ardesigner.basic.repository.interfaces

import com.example.android.ardesigner.basic.data.Category

interface ICategoryRepository {

    suspend fun getCategoriesList(): List<Category>

}