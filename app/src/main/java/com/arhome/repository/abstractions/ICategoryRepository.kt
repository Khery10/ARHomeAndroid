package com.arhome.repository.abstractions

import androidx.lifecycle.LiveData
import com.arhome.data.Category
import com.arhome.utils.repo.Resource

interface ICategoryRepository {

     fun getCategoriesList(): LiveData<Resource<List<Category>>>
}