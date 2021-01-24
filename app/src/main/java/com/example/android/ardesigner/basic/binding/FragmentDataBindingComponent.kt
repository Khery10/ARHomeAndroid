package com.example.android.ardesigner.basic.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    private val adapter = FragmentBindingAdapter(fragment)

    override fun getFragmentBindingAdapter() = adapter
}

