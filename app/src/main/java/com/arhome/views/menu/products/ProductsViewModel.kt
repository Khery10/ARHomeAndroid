package com.arhome.views.menu.products

import androidx.lifecycle.*
import com.arhome.data.Category
import com.arhome.repository.abstractions.IProductRepository
import com.arhome.utils.lifecycle.AbsentLiveData
import com.arhome.utils.repo.ResourceStatus
import java.util.*
import javax.inject.Inject

class ProductsViewModel @Inject constructor(productRepository: IProductRepository) : ViewModel() {

    private val _categoryTitle = MutableLiveData<String?>()
    private val _categoryId = MutableLiveData<UUID>()

    val categoryTitle: LiveData<String?> get() = _categoryTitle

    val products = _categoryId.switchMap { categoryId ->
        if (categoryId == null) {
            AbsentLiveData.create()
        } else {
            productRepository.getProductsByCategoryId(categoryId)
        }
    }

    val isEmpty = products.map { resource ->
        resource.status == ResourceStatus.SUCCESS && (resource.data?.isEmpty() ?: true)
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