package com.example.studentroom.data

import androidx.annotation.DrawableRes
import com.example.studentroom.R

data class SocProfile constructor(
    val id: Int,
    val name: String,
    val desc: String,
    @DrawableRes val imageResourceId: Int
)

val userList = arrayListOf(
    SocProfile(
        id = 1,
        name = "Quantum Computing Club",
        desc = "Leading research-driven society",
        R.drawable.aimonitors
    )
)