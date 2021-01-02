package com.example.android.camera.utils.sliding

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlidingImagesAdapter(activity: AppCompatActivity, private val fileNames: Array<String>) :
        FragmentStateAdapter(activity) {


    override fun getItemCount() = fileNames.size

    override fun createFragment(position: Int): Fragment = SlidingImageFragment.getInstance(fileNames[position])
}