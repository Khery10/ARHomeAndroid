package com.arhome.views.menu.products

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.data.Category
import com.arhome.databinding.ProductsFragmentBinding
import com.arhome.views.abstractions.FragmentWithViewModel
import kotlinx.android.synthetic.main.products_fragment.*
import kotlinx.android.synthetic.main.products_fragment.back_to_previous_button
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import java.util.*
import javax.inject.Inject

class ProductsFragment : FragmentWithViewModel<ProductsViewModel, ProductsFragmentBinding>(
        ProductsViewModel::class.java,
        R.layout.products_fragment) {

    @Inject
    lateinit var appExecutors: AppExecutors

    private val _args: ProductsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.setCategory(Category(UUID.fromString(_args.categoryId), _args.categoryTitle, null, null))

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ProductItemAdapter(FragmentDataBindingComponent(this), appExecutors) {
        }

        binding.productsList.adapter = adapter

        OverScrollDecoratorHelper.setUpOverScroll(products_list, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)

        postponeEnterTransition()
        binding.productsList.doOnPreDraw {
            startPostponedEnterTransition()
        }

        initProducts(adapter)
        initButtons()
    }

    private fun initProducts(adapter: ProductItemAdapter) {

        viewModel.products.observe(viewLifecycleOwner, {
            adapter.submitList(it?.data)
        })
    }

    private fun initButtons(){

        back_to_previous_button.setOnClickListener { findNavController().popBackStack() }
    }
}