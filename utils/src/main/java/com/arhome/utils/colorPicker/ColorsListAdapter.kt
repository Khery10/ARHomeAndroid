package com.arhome.utils.colorPicker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android.camera.utils.R


class ColorsListAdapter(
        private val context: Context) : ListAdapter<Int, ColorViewHolder>(object : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldColor: Int, newColor: Int) = oldColor == newColor

    override fun areContentsTheSame(oldColor: Int, newColor: Int) = oldColor == newColor
}) {

    private val holderCheckListener = OnColorCheckListener()
    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    fun setOnClickListener(callback: (Int) -> Unit) {
        holderCheckListener.setOnColorClickCallback(callback)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        var view = inflater.inflate(R.layout.color_view, parent, false)
        return ColorViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {

        var color = getItem(position)

        holder.setColor(color)
        holder.setOnColorCheckListener(holderCheckListener)
    }
}

class OnColorCheckListener : ColorViewHolder.OnColorCheckListener {

    private var currentHolder: ColorViewHolder? = null
    private var clickCallback: ((Int) -> Unit)? = null

    fun setOnColorClickCallback(callback: (Int) -> Unit) {
        clickCallback = callback
    }

    override fun onChecked(holder: ColorViewHolder) {
        currentHolder?.unchecked()
        holder.checked()

        currentHolder = holder
        clickCallback?.invoke(holder.color!!)
    }
}

