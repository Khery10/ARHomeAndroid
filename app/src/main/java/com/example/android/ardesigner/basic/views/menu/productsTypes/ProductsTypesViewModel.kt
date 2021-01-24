package com.example.android.ardesigner.basic.views.menu.productsTypes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.ardesigner.basic.data.ProductType
import com.example.android.ardesigner.basic.repository.interfaces.IProductRepository
import javax.inject.Inject


class ProductsTypesViewModel @Inject constructor(val repository: IProductRepository) : ViewModel() {

    val productsTypes: LiveData<List<ProductType>> = getProductsTypes()

    fun getProductsTypes(): MutableLiveData<List<ProductType>> {
        val liveData = MutableLiveData<List<ProductType>>()
        liveData.value = repository.getAllProductsTypes()
        return liveData
    }
}