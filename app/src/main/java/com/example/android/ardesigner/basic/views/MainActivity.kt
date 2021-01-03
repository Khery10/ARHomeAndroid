package com.example.android.ardesigner.basic.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.android.ardesigner.basic.R
import com.example.android.ardesigner.basic.views.fragments.CameraActivity
import com.example.android.camera.utils.sliding.SlidingImageManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val slidingManager = SlidingImageManager(this)
        slidingManager.onCreate()

        Handler().postDelayed(object : Runnable {
            override fun run() {
                startActivity(Intent(this@MainActivity, CameraActivity::class.java))
                slidingManager.onDestroy()
                finish()
            }
        }, 5000)
    }
}