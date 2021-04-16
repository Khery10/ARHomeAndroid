package com.arhome.views.menu.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arhome.data.Category
import com.arhome.repository.interfaces.ICategoryRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class CategoryViewModel @Inject constructor(val repository: ICategoryRepository) : ViewModel() {

    val categories: MutableLiveData<List<Category>> = MutableLiveData<List<Category>>(listOf())

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    fun fetchCategories() {

        scope.launch {
            val categoriesList = repository.getCategoriesList()
            categories.postValue(categoriesList)
        }
    }
}