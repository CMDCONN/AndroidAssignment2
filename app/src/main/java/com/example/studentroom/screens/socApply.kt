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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentroom.components.socApplyComponents.SocApplyViewModel

@Composable
fun SocApply(navController: NavController, socApplyViewModel: SocApplyViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
            .verticalScroll(rememberScrollState())
    )
    {
        Text(
            text = "Socs",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)),
            modifier = Modifier.padding(top = 20.dp)
        )
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
                Text(
                    text = soc,
                    color = Color.Black
                )
            }
        }
// order details
        // Gross awful terrible i hate it | ------------------------------------------------------------------------------------
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = socApplyViewModel.studentId,
            onValueChange = { socApplyViewModel.studentId = it },
            label = { Text("Student ID") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // https://developer.android.com/reference/kotlin/androidx/compose/material3/OutlinedTextFieldDefaults
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = socApplyViewModel.reason,
            onValueChange = { socApplyViewModel.reason = it },
            label = { Text("Reason for joining") },
            modifier = Modifier.fillMaxWidth(),
            // https://developer.android.com/reference/kotlin/androidx/compose/material3/OutlinedTextFieldDefaults
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )
        // Gross awful terrible i hate it | ------------------------------------------------------------------------------------

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
            onClick = { socApplyViewModel.isSubmitted = true },
            shape = RectangleShape,
            // Setting the background and content colors
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text("Click here to join!")
        }

        if (socApplyViewModel.isSubmitted) {
            val price = socApplyViewModel.socPrices[socApplyViewModel.selectedSoc] ?: 0
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "You have joined: ${socApplyViewModel.selectedSoc}",
                color = Color.DarkGray,
                fontSize = 18.sp,
            )
            Text(
                text = "Membership Price: £$price",
                color = Color.DarkGray,
                fontSize = 16.sp,
            )
            var pricex2 = price*1.5
            Text(
                text = "Special offer right now get second ticket for 50% off: £$pricex2",
                color = Color.DarkGray,
                fontSize = 16.sp,
            )
        }
    }
}



