package com.arhome.views.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.data.interfaces.ITextImageData
import com.arhome.databinding.CatalogItemBinding

class CatalogItemsAdapter(
        private val dataBindingComponent: FragmentDataBindingComponent,
        appExecutors: AppExecutors,
        private val callback: (() -> Unit)?)
    : DataBoundListAdapter<ITextImageData, CatalogItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<ITextImageData>() {

            override fun areItemsTheSame(oldItem: ITextImageData, newItem: ITextImageData)
                    = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ITextImageData, newItem: ITextImageData)
                    = oldItem.imageUrl == newItem.imageUrl && oldItem.name == newItem.name

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
                callback?.invoke()
            }
        }

        return binding
    }

    override fun bind(binding: CatalogItemBinding, item: ITextImageData) {
        binding.item = item
    }
}
