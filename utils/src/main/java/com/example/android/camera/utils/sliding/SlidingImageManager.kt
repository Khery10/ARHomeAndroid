package com.example.android.camera.utils.sliding

import android.os.Handler
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android.camera.utils.R
import kotlinx.android.synthetic.main.sliding_activity_main.*
import java.util.*

class SlidingImageManager constructor(val activity: AppCompatActivity) {

    private var currentPage = 0
    private var imagesCount = 0
    private var timer: Timer? = null

    fun onCreate() {
        activity.setContentView(R.layout.sliding_activity_main)
        setUpSlidingViewPager()
    }

    private fun setUpSlidingViewPager() {

        val imagesArray = this.activity?.application?.assets!!
                .list(activity.getString(R.string.ic_slider_dir))!!

        val fullFilesNames = imagesArray.map {
            "file:///android_asset/${activity.getString(R.string.ic_slider_dir)}/$it"
        }.toTypedArray()

        activity.slidingViewPager.apply {
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
            activity.slidingViewPager.setCurrentItem(currentPage++, true)
        }

        timer = Timer()
        timer?.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(update)
            }
        }, 3000, 3000)
    }

    fun onDestroy() {
        timer?.cancel()
    }
}