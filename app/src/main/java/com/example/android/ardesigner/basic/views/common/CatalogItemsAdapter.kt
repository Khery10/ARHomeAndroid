package com.example.android.ardesigner.basic.views.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.android.ardesigner.basic.AppExecutors
import com.example.android.ardesigner.basic.R
import com.example.android.ardesigner.basic.binding.FragmentDataBindingComponent
import com.example.android.ardesigner.basic.common.DataBoundListAdapter
import com.example.android.ardesigner.basic.data.ITextImageItem
import com.example.android.ardesigner.basic.databinding.CatalogItemFragmentBinding

class CatalogItemsAdapter(
        private val dataBindingComponent: FragmentDataBindingComponent,
        appExecutors: AppExecutors,
        private val callback: (() -> Unit)?)
    : DataBoundListAdapter<ITextImageItem, CatalogItemFragmentBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<ITextImageItem>() {

            override fun areItemsTheSame(oldItem: ITextImageItem, newItem: ITextImageItem)
                    = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ITextImageItem, newItem: ITextImageItem)
                    = oldItem.imgUrl == newItem.imgUrl && oldItem.name == newItem.name

        }
) {
    override fun createBinding(parent: ViewGroup): CatalogItemFragmentBinding {
        val binding = DataBindingUtil
                .inflate<CatalogItemFragmentBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.catalog_item_fragment,
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

    override fun bind(binding: CatalogItemFragmentBinding, item: ITextImageItem) {
        binding.item = item
    }
}
