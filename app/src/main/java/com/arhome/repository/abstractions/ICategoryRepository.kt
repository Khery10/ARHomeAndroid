package com.arhome.repository.abstractions

import androidx.lifecycle.LiveData
import com.arhome.data.Category
import com.arhome.data.SurfaceType
import com.arhome.utils.repo.Resource

interface ICategoryRepository {

    fun getCategoriesList(): LiveData<Resource<Array<Category>>>

    fun getCategoriesBySurface(surface: SurfaceType): LiveData<Resource<Array<Category>>>
}