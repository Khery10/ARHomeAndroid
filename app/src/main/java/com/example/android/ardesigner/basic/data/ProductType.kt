package com.example.android.ardesigner.basic.data

import java.util.*

data class ProductType(
        override val id: Int,
        override val name: String,
        override val imgUrl: String) : ITextImageItem