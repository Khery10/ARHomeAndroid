package com.example.android.ardesigner.basic.views.loading

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlidingImagesAdapter(activity: FragmentActivity, private val fileNames: Array<String>) :
        FragmentStateAdapter(activity) {


    override fun getItemCount() = fileNames.size

    override fun createFragment(position: Int): Fragment = SlidingImageFragment.getInstance(fileNames[position])
}