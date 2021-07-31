package com.arhome.utils.colorPicker

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android.camera.utils.R

class RecyclerColorPicker : RecyclerView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val colorsAdapter: ColorsListAdapter

    init {
        colorsAdapter = ColorsListAdapter(context).apply { submitList(getColorsList(context)) }
        adapter = colorsAdapter
    }

    fun setOnColorSelectedListener(callback: (Int) -> Unit) {
        colorsAdapter.setOnClickListener(callback)
    }

    companion object {
        fun getColorsList(context: Context): List<Int> {
            return listOf(
                    ContextCompat.getColor(context, R.color.color_picker_0),
                    ContextCompat.getColor(context, R.color.color_picker_1),
                    ContextCompat.getColor(context, R.color.color_picker_2),
                    ContextCompat.getColor(context, R.color.color_picker_3),
                    ContextCompat.getColor(context, R.color.color_picker_4),
                    ContextCompat.getColor(context, R.color.color_picker_5),
                    ContextCompat.getColor(context, R.color.color_picker_6),
                    ContextCompat.getColor(context, R.color.color_picker_7),
                    ContextCompat.getColor(context, R.color.color_picker_8),
                    ContextCompat.getColor(context, R.color.color_picker_9),
                    ContextCompat.getColor(context, R.color.color_picker_10),
                    ContextCompat.getColor(context, R.color.color_picker_11),
                    ContextCompat.getColor(context, R.color.color_picker_12),
                    ContextCompat.getColor(context, R.color.color_picker_13))
        }
    }
}