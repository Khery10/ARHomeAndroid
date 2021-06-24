package com.arhome.views.segmentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arhome.R
import com.arhome.databinding.ImageViewerFragmentBinding
import com.arhome.utils.io.saveJpgImageToDCIM
import com.arhome.views.abstractions.FragmentWithViewModel
import kotlinx.android.synthetic.main.image_viewer_fragment.*
import java.io.File

class SegmentationViewerFragment : FragmentWithViewModel<SegmentationViewModel, ImageViewerFragmentBinding>(
        SegmentationViewModel::class.java,
        R.layout.image_viewer_fragment) {

    private val _args: SegmentationViewerFragmentArgs by navArgs()
    private var _saved = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.segmentedImage = viewModel.data
        binding.lifecycleOwner = viewLifecycleOwner

        back_to_previous_button.setOnClickListener { findNavController().popBackStack() }
        save_image_button.setOnClickListener { saveImageView() }

        viewModel.defineImage(_args.filePath)
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
