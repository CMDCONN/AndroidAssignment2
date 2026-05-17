package com.example.studentroom.data

import androidx.annotation.DrawableRes
import com.example.studentroom.R

data class SocProfile constructor(
    val id: Int,
    val name: String,
    val desc: String,
    @DrawableRes val imageResourceId: Int
)

val socList = arrayListOf(
    SocProfile(
        id = 1,
        name = "Quantum Computing Club",
        desc = "Leading research-driven society",
        R.drawable.aimonitors
    ),
    SocProfile(
        id = 2,
        name = "Life Drawing Society",
        desc = "a community forged around drawing",
        R.drawable.lifedrawing
    ),
    SocProfile(
        id = 3,
        name = "Mariocart Society",
        desc = "Come and play mariocart and enjoy making new friends",
        R.drawable.computer_screen
    )
)