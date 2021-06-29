package com.arhome.views.menu.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.arhome.data.SurfaceType
import com.arhome.repository.abstractions.ICategoryRepository
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(val repository: ICategoryRepository) : ViewModel() {

    val surfaceType = MutableLiveData<SurfaceType>()

    val categories = surfaceType.switchMap {
        if (it == SurfaceType.All)
            repository.getCategoriesList()
        else
            repository.getCategoriesBySurface(it)
    }

    fun setSurface(surface: SurfaceType) {
        if(surfaceType.value != surface)
            surfaceType.postValue(surface)
    }

    fun retry() {
    }
}