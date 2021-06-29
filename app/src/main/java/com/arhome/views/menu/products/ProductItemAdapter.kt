package com.arhome.views.menu.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.data.Product
import com.arhome.databinding.ProductItemBinding
import com.arhome.views.common.DataBoundListAdapter

class ProductItemAdapter(
        private val dataBindingComponent: FragmentDataBindingComponent,
        appExecutors: AppExecutors,
        private val productImgUrlProvider: ((Product) -> String),
        private val callback: (() -> Unit)?)
    : DataBoundListAdapter<Product, ProductItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<Product>() {

            override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem.name == newItem.name && oldItem.categoryId == newItem.categoryId

        }
) {
    override fun createBinding(parent: ViewGroup): ProductItemBinding {
        val binding = DataBindingUtil
                .inflate<ProductItemBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.product_item,
                        parent,
                        false,
                        dataBindingComponent)

        binding.root.setOnClickListener {
            binding.item?.let {
                callback?.invoke()
            }
        }

        return binding
    }

    override fun bind(binding: ProductItemBinding, item: Product) {
        binding.item = item
        binding.productImgUrl = productImgUrlProvider(item)
    }
}