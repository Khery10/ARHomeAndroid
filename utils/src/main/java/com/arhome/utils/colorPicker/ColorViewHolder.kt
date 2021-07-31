package com.arhome.utils.colorPicker

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.camera.utils.R

class ColorViewHolder internal constructor(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val view: View = itemView.findViewById(R.id.color_view)
    private val shape: GradientDrawable by lazy {
        (view.background as LayerDrawable).findDrawableByLayerId(R.id.shape_id) as GradientDrawable
    }

    var color: Int? = null
        private set

    fun setColor(argb: Int) {
        shape.setColor(argb)
        color = argb
    }

    fun checked() {
        shape.setStroke((4 * context.resources.displayMetrics.density).toInt(), Color.WHITE)
    }

    fun unchecked() {
        shape.setStroke((2 * context.resources.displayMetrics.density).toInt(), Color.WHITE)
    }

    fun setOnColorCheckListener(listener: OnColorCheckListener) {
        view.setOnClickListener {
            listener.onChecked(this)
        }
    }

    interface OnColorCheckListener {
        fun onChecked(holder: ColorViewHolder)
    }
}