package com.example.studentroom.screens

import com.example.studentroom.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.studentroom.components.socApplyComponents.SocApplyViewModel

@Composable
fun SocApply(navController: NavController, socApplyViewModel: SocApplyViewModel) {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
            .verticalScroll(rememberScrollState()))
        {
            Text("Socs")
// RadioButtons
            socApplyViewModel.Socs.forEach { soc ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .selectable(
                            selected = socApplyViewModel.selectedSoc == soc,
                            onClick = { socApplyViewModel.selectedSoc = soc },
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = socApplyViewModel.selectedSoc == soc,
                        onClick = null,
                    )
                    Text(soc)
                }
            }
// order details
            Spacer(modifier = Modifier.height(24.dp))
            Button( onClick = { /* TODO */ }) { Text("Place order") }
        }
    }
