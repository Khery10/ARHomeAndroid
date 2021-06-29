package com.arhome.data

import com.arhome.data.abstractions.ITitleData
import java.util.*

data class Category(
        override val id: UUID,
        override val name: String,
        val description: String?) : ITitleData