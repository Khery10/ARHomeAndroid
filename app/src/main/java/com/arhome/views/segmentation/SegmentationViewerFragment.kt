package com.arhome.views.segmentation

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.util.Log
import android.util.TimingLogger
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.doOnPreDraw
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
import com.arhome.utils.colorPicker.ColorsListAdapter
import com.arhome.utils.io.saveJpgImageToDCIM
import com.arhome.views.abstractions.FragmentWithViewModel
import com.github.chrisbanes.photoview.OnPhotoTapListener
import com.github.chrisbanes.photoview.PhotoViewAttacher
import kotlinx.android.synthetic.main.image_viewer_fragment.*
import kotlinx.android.synthetic.main.image_viewer_fragment.back_to_previous_button
import kotlinx.android.synthetic.main.image_viewer_fragment.view.*
import kotlinx.android.synthetic.main.products_fragment.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import java.io.File
import javax.inject.Inject
import kotlin.system.measureTimeMillis

class SegmentationViewerFragment : FragmentWithViewModel<SegmentationViewModel, ImageViewerFragmentBinding>(
        SegmentationViewModel::class.java,
        R.layout.image_viewer_fragment) {

    @Inject
    lateinit var imageRenderer: IImageRenderer

    private var currentColor: Int? = null
    private val _args: SegmentationViewerFragmentArgs by navArgs()
    private var _saved = false

    private val imageBitmap: Bitmap by lazy {
        (imageViewer.drawable as BitmapDrawable).bitmap
    }
    private val imageCanvas: Canvas by lazy {
        Canvas(imageBitmap)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        view!!.imageViewer.scaleType = ImageView.ScaleType.FIT_XY

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.segmentedImage = viewModel.data
        binding.imagePath = viewModel.imagePath
        binding.lifecycleOwner = viewLifecycleOwner

        back_to_previous_button.setOnClickListener { findNavController().popBackStack() }
        save_image_button.setOnClickListener { saveImage() }

        initColorPicker()

        imageViewer.setOnPhotoTapListener { image, x, y ->
            photoTapListener(image, x, y)
        }

        requireActivity().supportFragmentManager.setFragmentResultListener("selected_color", this) { _, bundle ->
            var color = bundle.getInt("color")
            var surfaceString = bundle.getString("surfaceType")

            changeColor(SurfaceType.valueOf(surfaceString!!), color)
        }

        viewModel.defineImage(_args.filePath)
    }

    private fun photoTapListener(image: ImageView, x: Float, y: Float) {
        var data = viewModel.data.value!!.data!!
        var bitmap = getImageViewBitmap(imageViewer)

        val x = (x * bitmap.width).toInt()
        val y = (y * bitmap.height).toInt()

        var surface = when {
            data.isWall(x, y) -> SurfaceType.Wall
            data.isFloor(x, y) -> SurfaceType.Floor
            else -> return
        }

        if (currentColor != null)
            changeColor(surface, currentColor!!)
        else
            showCategory(surface)
    }

    private fun initColorPicker() {

        var colorizeShape = (colorize.background as LayerDrawable).findDrawableByLayerId(com.example.android.camera.utils.R.id.shape_id) as GradientDrawable

        color_picker.setOnColorSelectedListener {
            colorizeShape.setColor(it)
            currentColor = it
        }

        color_picker.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    private fun saveImage() {

        if (!_saved) {
            saveJpgImageToDCIM(requireContext(), getImageViewBitmap(imageViewer))

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

        var mask: List<Point> = when (surface) {
            SurfaceType.Floor -> viewModel.data.value!!.data!!.floorPixels
            SurfaceType.Wall -> viewModel.data.value!!.data!!.wallPixels
            else -> throw IllegalArgumentException("surface not correct")
        }

        var applyMills = measureTimeMillis {

            var paint = Paint()
            paint.color = color

            for (a in mask)
                imageCanvas.drawPoint(a.x.toFloat(), a.y.toFloat(), paint)
        }

        imageViewer.invalidate()
        Log.d("TRACE_COLOR", applyMills.toString())
    }

    private fun getImageViewBitmap(imageView: ImageView) = (imageView.drawable as BitmapDrawable).bitmap

}
