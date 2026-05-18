package com.example.studentroom.components.socApplyComponents

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SocApplyViewModel : ViewModel(){
    val Socs = listOf("Quantum Computing Club", "Life Drawing society", "Mariocart Society")
    var selectedSoc by mutableStateOf("Quantum Computing Club")
}