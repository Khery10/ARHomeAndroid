package com.arhome.views.segmentation

import android.os.Bundle
import android.view.MotionEvent
import android.view.Surface
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arhome.R
import com.arhome.data.SurfaceType
import com.arhome.databinding.ImageViewerFragmentBinding
import com.arhome.utils.io.saveJpgImageToDCIM
import com.arhome.views.abstractions.FragmentWithViewModel
import com.arhome.views.menu.categories.CategoriesFragment
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


        imageViewer.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {

                if (v == null || event == null)
                    return false

                val x = event.x.toInt()
                val y = event.y.toInt()

                if (viewModel.data.value!!.data!!.isWall(x, y))
                    showCategory(SurfaceType.Wall)

                if (viewModel.data.value!!.data!!.isFloor(x, y))
                    showCategory(SurfaceType.Floor)

                return false
            }
        })

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

    private fun showCategory(surface: SurfaceType) {
        requireActivity()!!.supportFragmentManager
                .beginTransaction()
                .add(R.id.catalogContainer, CategoriesFragment(surface))
                .addToBackStack(null)
                .commit()
    }

}
