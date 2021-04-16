package com.arhome.views.loading

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.arhome.R
import kotlinx.android.synthetic.main.loading_image.view.*

class SlidingImageFragment : Fragment() {

    companion object {
        const val ARG_FILENAME = "fullFileName"

        fun getInstance(fullFileName: String): SlidingImageFragment {
            val fragment = SlidingImageFragment()
            val bundle = Bundle()
            bundle.putString(ARG_FILENAME, fullFileName)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.loading_image, container, false)

        val fullFileName = requireArguments().getString(ARG_FILENAME)
        val uri = Uri.parse(fullFileName)

        Glide.with(view.loading_image)
                .load(uri)
                .into(view.loading_image)

        return view
    }
}