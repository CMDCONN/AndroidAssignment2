package com.example.studentroom.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentroom.components.SocPicture
import com.example.studentroom.data.SocProfile

@Composable
fun SocsDetailPage(socListIn: List<SocProfile>, id: String?){

    val soc = socListIn.find { it.id.toString() == id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ){
        if (soc != null) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocPicture(socProfile = soc, socPicSize = 200.dp)
            }

            Spacings(20.dp)


            Text(
                text = soc.name,
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacings(10.dp)


            Text(
                text = soc.desc,
                color = Color.DarkGray,
                fontSize = 18.sp
            )
        } else {

            Text(text = "Society not found", color = Color.Red)
        }
    }
}


@Composable
fun Spacings(spacerHeight: Dp){
    Spacer(modifier = Modifier.height(spacerHeight))
}