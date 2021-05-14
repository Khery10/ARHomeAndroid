package com.arhome.views.camera

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arhome.R
import com.arhome.databinding.ImageViewerFragmentBinding
import com.arhome.utils.io.saveJpgImageToDCIM
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.image_viewer_fragment.*
import kotlinx.android.synthetic.main.image_viewer_fragment.view.*
import java.io.File

class ImageViewerFragment : Fragment() {

    private val _args: ImageViewerFragmentArgs by navArgs()

    private val _loaded: MutableLiveData<Boolean> = MutableLiveData(false)

    private lateinit var _binding: ImageViewerFragmentBinding

    private var _saved = false

    private val _loadListener: RequestListener<Drawable> by lazy {
        object : RequestListener<Drawable> {

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
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(
                inflater,
                R.layout.image_viewer_fragment,
                container,
                false
        )

        _binding.loaded = _loaded
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_to_previous_button.setOnClickListener { findNavController().popBackStack() }
        save_image_button.setOnClickListener { saveImageView() }

        Glide.with(view.imageViewer)
                .load(_args.filePath)
                .listener(_loadListener)
                .into(view.imageViewer)
    }

    private fun saveImageView() {

        if (!_saved) {
            saveJpgImageToDCIM(requireContext(), File(_args.filePath))

            _saved = true
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(requireContext(), "Image already saved", Toast.LENGTH_SHORT).show()

    }
}
