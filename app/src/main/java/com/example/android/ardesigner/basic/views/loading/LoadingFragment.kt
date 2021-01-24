package com.example.android.ardesigner.basic.views.loading

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.ardesigner.basic.R

import kotlinx.android.synthetic.main.loading_fragment.*
import kotlinx.android.synthetic.main.loading_fragment.view.*


import java.util.*

class LoadingFragment : Fragment() {

    private var currentPage = 0
    private var imagesCount = 0
    private var timer: Timer? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.loading_fragment, container, false)
        setUpSlidingViewPager(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(object : Runnable {
            override fun run() {
                findNavController().navigate(LoadingFragmentDirections.actionLoadingToMenuFragment())
            }
        }, 5000)
    }

    private fun setUpSlidingViewPager(view: View) {

        var activity = this.requireActivity()

        val imagesArray = activity.application?.assets!!
                .list(activity.getString(R.string.ic_slider_dir))!!

        val fullFilesNames = imagesArray.map {
            "file:///android_asset/${activity.getString(R.string.ic_slider_dir)}/$it"
        }.toTypedArray()

        view.slidingViewPager.apply {
            adapter = SlidingImagesAdapter(activity, fullFilesNames)
            isUserInputEnabled = false
        }

        imagesCount = imagesArray.size

        val handler = Handler()
        val update = Runnable {
            if (currentPage == imagesArray.size) {
                currentPage = 0
            }

            //The second parameter ensures smooth scrolling
            this.slidingViewPager.setCurrentItem(currentPage++, true)
        }

        timer = Timer()
        timer?.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(update)
            }
        }, 3000, 3000)
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}