package com.arhome.views.segmentation

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arhome.R
import com.arhome.data.SurfaceType
import com.arhome.databinding.ImageViewerFragmentBinding
import com.arhome.segmentation.IImageRenderer
import com.arhome.utils.io.saveJpgImageToDCIM
import com.arhome.views.abstractions.FragmentWithViewModel
import com.github.chrisbanes.photoview.OnPhotoTapListener
import com.github.chrisbanes.photoview.PhotoViewAttacher
import kotlinx.android.synthetic.main.image_viewer_fragment.*
import kotlinx.android.synthetic.main.image_viewer_fragment.view.*
import java.io.File
import javax.inject.Inject

class SegmentationViewerFragment : FragmentWithViewModel<SegmentationViewModel, ImageViewerFragmentBinding>(
        SegmentationViewModel::class.java,
        R.layout.image_viewer_fragment) {

    @Inject
    lateinit var imageRenderer: IImageRenderer

    private val _args: SegmentationViewerFragmentArgs by navArgs()
    private var _saved = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.segmentedImage = viewModel.data
        binding.imagePath = viewModel.imagePath
        binding.lifecycleOwner = viewLifecycleOwner

        back_to_previous_button.setOnClickListener { findNavController().popBackStack() }
        save_image_button.setOnClickListener { saveImage() }

        imageViewer.setOnPhotoTapListener { image, x, y ->
            val x = (x * image.width).toInt()
            val y = (y * image.height).toInt()

            if (viewModel.data.value!!.data!!.isWall(x, y))
                showCategory(SurfaceType.Wall)

            if (viewModel.data.value!!.data!!.isFloor(x, y))
                showCategory(SurfaceType.Floor)
        }

        requireActivity().supportFragmentManager.setFragmentResultListener("selected_color", this) { _, bundle ->
            var color = bundle.getInt("color")
            var surfaceString = bundle.getString("surfaceType")

            changeColor(SurfaceType.valueOf(surfaceString!!), color)
        }

        viewModel.defineImage(_args.filePath)
    }

    private fun saveImage() {

        if (!_saved) {
            saveJpgImageToDCIM(requireContext(), (imageViewer.drawable as BitmapDrawable).bitmap)

            _saved = true
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(requireContext(), "Image already saved", Toast.LENGTH_SHORT).show()

    }

    private fun showCategory(surface: SurfaceType) {

        requireActivity()!!.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.pop_up_in, R.anim.fade_out, R.anim.fade_in, R.anim.pop_up_out)
                .add(R.id.catalogContainer, SelectingSurfaceFragment(surface))
                .commit()
    }

    private fun changeColor(surface: SurfaceType, color: Int) {

        var mask: Bitmap = when (surface) {
            SurfaceType.Floor -> viewModel.data.value!!.data!!.floorMask
            SurfaceType.Wall -> viewModel.data.value!!.data!!.wallMask
            else -> throw IllegalArgumentException("surface not correct")
        }

        var bitmap = (imageViewer.drawable as BitmapDrawable).bitmap
        bitmap = imageRenderer.applyColor(bitmap, mask, color)

        imageViewer.setImageBitmap(bitmap)
    }

}
