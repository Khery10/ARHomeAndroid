package com.arhome.views.segmentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.arhome.AppExecutors
import com.arhome.R
import com.arhome.api.ApiBuilder
import com.arhome.binding.FragmentDataBindingComponent
import com.arhome.data.SurfaceType
import com.arhome.databinding.SelectSurfaceFragmentBinding
import com.arhome.utils.repo.Resource
import com.arhome.utils.repo.ResourceStatus
import com.arhome.views.abstractions.FragmentWithViewModel
import com.arhome.views.common.CatalogItemsAdapter
import com.arhome.views.common.RetryCallback
import com.arhome.views.menu.MenuFragmentDirections
import com.arhome.views.menu.categories.CategoriesViewModel
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.flag.BubbleFlag
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import kotlinx.android.synthetic.main.catalog_fragment.catalog_item_list
import kotlinx.android.synthetic.main.select_surface_fragment.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import javax.inject.Inject

class SelectingSurfaceFragment : FragmentWithViewModel<CategoriesViewModel, SelectSurfaceFragmentBinding> {

    constructor() : this(SurfaceType.All)

    constructor(surface: SurfaceType) : super(CategoriesViewModel::class.java, R.layout.select_surface_fragment) {
        surfaceType = surface
    }


    private val surfaceType: SurfaceType

    @Inject
    lateinit var appExecutors: AppExecutors

    @Inject
    lateinit var apiBuilder: ApiBuilder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        binding.retryCallback = object : RetryCallback {
            override fun retry() {
                viewModel.retry()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.surface = surfaceType
        binding.resource = viewModel.categories as LiveData<Resource<Any>>
        binding.lifecycleOwner = viewLifecycleOwner

        close_button.setOnClickListener { close() }
        select_color_button.setOnClickListener { openSelectColorDialog() }

        val adapter = CatalogItemsAdapter(
                FragmentDataBindingComponent(this),
                appExecutors,
                { apiBuilder.getCategoryAviconUrl(it.id) },
                { findNavController().navigate(MenuFragmentDirections.menuToProducts(it.id.toString(), it.name)) })

        binding.catalogItemList.adapter = adapter

        OverScrollDecoratorHelper.setUpOverScroll(catalog_item_list, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)

        postponeEnterTransition()
        binding.catalogItemList.doOnPreDraw {
            startPostponedEnterTransition()
        }

        viewModel.setSurface(surfaceType)
        observeCategories(adapter)
    }

    private fun observeCategories(adapter: CatalogItemsAdapter) {

        viewModel.categories.observe(viewLifecycleOwner, {

            if (it.status == ResourceStatus.SUCCESS)
                adapter.submitList(it?.data?.toList())

        })
    }

    private fun openSelectColorDialog() {

        var builder = ColorPickerDialog
                .Builder(requireContext())
                .setTitle(R.string.select_color_header)
                .attachAlphaSlideBar(false)
                .setPositiveButton("OK", object : ColorEnvelopeListener {
                    override fun onColorSelected(envelope: ColorEnvelope?, fromUser: Boolean) {
                        if (envelope != null) {

                            var bundle = bundleOf(
                                    "color" to envelope!!.color,
                                    "surfaceType" to surfaceType.toString())

                            requireActivity().supportFragmentManager.setFragmentResult("selected_color", bundle)
                            close()
                        }
                    }
                })

        builder.colorPickerView.flagView = BubbleFlag(requireContext())
        builder.show()
    }

    private fun close() {

        requireActivity()!!
                .supportFragmentManager
                .beginTransaction()
                .remove(this)
                .commit()
    }
}