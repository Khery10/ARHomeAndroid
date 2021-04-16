package com.arhome.repository.interfaces

import com.arhome.data.Category

interface ICategoryRepository {

    suspend fun getCategoriesList(): List<Category>

}