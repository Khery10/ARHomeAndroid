package com.arhome.views.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.data.abstractions.ITitleData
import com.arhome.databinding.CatalogItemBinding

class CatalogItemsAdapter(
        private val dataBindingComponent: FragmentDataBindingComponent,
        appExecutors: AppExecutors,
        private val imageUrlProvider: ((ITitleData) -> String),
        private val callback: ((ITitleData) -> Unit)?)

    : DataBoundListAdapter<ITitleData, CatalogItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<ITitleData>() {

            override fun areItemsTheSame(oldItem: ITitleData, newItem: ITitleData) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ITitleData, newItem: ITitleData) = oldItem.name == newItem.name

        }
) {
    override fun createBinding(parent: ViewGroup): CatalogItemBinding {
        val binding = DataBindingUtil
                .inflate<CatalogItemBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.catalog_item,
                        parent,
                        false,
                        dataBindingComponent)

        binding.root.setOnClickListener {
            binding.item?.let {
                callback?.invoke(it)
            }
        }

        return binding
    }

    override fun bind(binding: CatalogItemBinding, item: ITitleData) {
        binding.item = item
        binding.imageUrl = imageUrlProvider(item)
    }
}
