package com.example.android.ardesigner.basic.views.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.ardesigner.basic.R
import com.example.android.ardesigner.basic.views.menu.productsTypes.ProductsTypesFragment
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.menu_fragment.view.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.menu_fragment, container, false)

        val creators = mapOf<Int, () -> Fragment>(0 to { ProductsTypesFragment() })
        view.catalogs_viewer.apply {
            adapter = object : FragmentStateAdapter(this@MenuFragment) {

                override fun getItemCount() = creators.size
                override fun createFragment(position: Int) = creators[position]?.invoke()!!
            }

            isUserInputEnabled = false
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createViewAnimation(view)
    }

    private fun createViewAnimation(view: View) {
        OverScrollDecoratorHelper.setUpOverScroll(horizontal_scroll_header)
    }
}