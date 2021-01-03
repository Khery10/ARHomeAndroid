package com.example.android.ardesigner.basic.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import com.example.android.ardesigner.basic.R
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MenuFragment : Fragment(R.layout.fragment_catalog_collections) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createViewAnimation(view)
    }

    private fun createViewAnimation(view: View) {
        val horizontalView = view.findViewById<HorizontalScrollView>(R.id.horizontal_scroll_header)
        OverScrollDecoratorHelper.setUpOverScroll(horizontalView)
    }

}