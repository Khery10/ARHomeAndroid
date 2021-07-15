package com.arhome.binding

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class FragmentBindingAdapter constructor(val fragment: Fragment) {


    companion object {

        @JvmStatic
        @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }

        @JvmStatic
        @BindingAdapter(value = ["imageContent"])
        fun loadImage(view: View, content: ByteArray?) {
            Glide.with(view.context).load(content).into(view as ImageView)
        }

        @JvmStatic
        @BindingAdapter(value = ["imageUrl"], requireAll = false)
        fun bindImage(view: View, url: String?) {
            Glide.with(view.context).load(url).into(view as ImageView)
        }
    }

}