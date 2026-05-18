package com.example.studentroom.components.socApplyComponents

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SocApplyViewModel : ViewModel(){
    val Socs = listOf("Quantum Computing Club", "Life Drawing society", "Mariocart Society")
    val socPrices = mapOf(
        "Quantum Computing Club" to 5,
        "Life Drawing society" to 10,
        "Mariocart Society" to 3
    )
    var selectedSoc by mutableStateOf("Quantum Computing Club")
    var studentId by mutableStateOf("")
    var reason by mutableStateOf("")
    var isSubmitted by mutableStateOf(false)
}