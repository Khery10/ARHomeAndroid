package com.arhome.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arhome.di.ViewModelKey
import com.arhome.viewModel.AppViewModelFactory
import com.arhome.views.menu.categories.CategoriesViewModel
import com.arhome.views.menu.products.ProductsViewModel
import com.arhome.views.segmentation.SegmentationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    abstract fun bindCategoryViewMode(categoryViewModel: CategoriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindProductsViewModel(productsViewModel: ProductsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SegmentationViewModel::class)
    abstract fun bindSegmentationViewModel(segmentationViewModel: SegmentationViewModel) : ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}