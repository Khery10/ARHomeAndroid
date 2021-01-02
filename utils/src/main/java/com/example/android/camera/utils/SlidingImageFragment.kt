package com.example.android.camera.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sliding.*

class SlidingImageFragment : Fragment(R.layout.fragment_sliding) {

    companion object {
        const val ARG_POSITION = "position"

        fun getInstance(position: Int): Fragment {
            val fragment = SlidingImageFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)

    }
}