package com.arhome.views.camera

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arhome.R
import com.arhome.databinding.ImageViewerFragmentBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.image_viewer_fragment.*
import kotlinx.android.synthetic.main.image_viewer_fragment.view.*

class ImageViewerFragment : Fragment() {

    private val navController: NavController by lazy {
        findNavController()
    }

    /** AndroidX navigation arguments */
    private val args: ImageViewerFragmentArgs by navArgs()

    private val _loaded: MutableLiveData<Boolean> = MutableLiveData(false)

    lateinit var binding: ImageViewerFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.image_viewer_fragment,
                container,
                false
        )

        binding.loaded = _loaded
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_to_previous_button.setOnClickListener {
            findNavController().popBackStack()
        }

        Glide.with(view.imageViewer).load(args.filePath).listener(object : RequestListener<Drawable> {

            override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean): Boolean {

                return false
            }

            override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean): Boolean {

                _loaded.postValue(true)
                return false
            }

        }).into(view.imageViewer)
    }
}
