package com.arhome.views.menu.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.databinding.CatalogFragmentBinding
import com.arhome.di.Injectable
import com.arhome.utils.repo.Resource
import com.arhome.views.abstractions.FragmentWithViewModel
import com.arhome.views.common.CatalogItemsAdapter
import com.arhome.views.common.RetryCallback
import com.arhome.views.menu.MenuFragmentDirections
import kotlinx.android.synthetic.main.catalog_fragment.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import java.util.*
import javax.inject.Inject

class CategoryFragment : FragmentWithViewModel<CategoryViewModel, CatalogFragmentBinding>(
        CategoryViewModel::class.java,
        R.layout.catalog_fragment) {

    @Inject
    lateinit var appExecutors: AppExecutors

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        binding.retryCallback = object : RetryCallback {
            override fun retry() {
                viewModel.retry()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.resource = viewModel.categories as LiveData<Resource<Any>>
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = CatalogItemsAdapter(FragmentDataBindingComponent(this), appExecutors) {
            findNavController().navigate(MenuFragmentDirections.menuToProducts(it.id.toString(), it.name))
        }

        binding.catalogItemList.adapter = adapter

        OverScrollDecoratorHelper.setUpOverScroll(catalog_item_list, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)

        postponeEnterTransition()
        binding.catalogItemList.doOnPreDraw {
            startPostponedEnterTransition()
        }

        initCategories(adapter)
    }

    private fun initCategories(adapter: CatalogItemsAdapter) {

        viewModel.categories.observe(viewLifecycleOwner, {
            adapter.submitList(it?.data)
        })
    }
}