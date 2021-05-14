package com.arhome.views.menu.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.arhome.data.Category
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.utils.lifecycle.AbsentLiveData
import javax.inject.Inject

class ProductsViewModel @Inject constructor(productRepository: IProductRepository) : ViewModel() {

    private val _categoryTitle = MutableLiveData<String?>()
    private val _categoryId = MutableLiveData<Int>()

    val categoryTitle: LiveData<String?> get() = _categoryTitle

    val products = _categoryId.switchMap { categoryId ->
        if (categoryId == null) {
            AbsentLiveData.create()
        } else {
            productRepository.getProductsByCategoryId(categoryId)
        }
    }

    fun setCategory(category: Category) {
        if (_categoryId.value != category.id) {
            _categoryId.value = category.id
        }

        if (_categoryTitle.value != category.name) {
            _categoryTitle.value = category.name
        }
    }
}