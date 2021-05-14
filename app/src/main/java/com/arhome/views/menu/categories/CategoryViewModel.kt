package com.arhome.views.menu.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arhome.data.Category
import com.arhome.repository.abstractions.ICategoryRepository
import com.arhome.utils.repo.Resource
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val repository: ICategoryRepository) : ViewModel() {

    val categories: LiveData<Resource<List<Category>>> = repository.getCategoriesList()

    fun retry() {
    }
}