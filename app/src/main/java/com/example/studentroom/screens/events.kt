package com.example.studentroom.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentroom.R

@Composable
fun Events() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        BarButtons()
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Featured Events",
            color = Color.Black,
            fontSize = 30.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
        )
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            SocBoxes("AI Ethics Guest Lecture",
                "Come and visit the ai guest lecture and learn lots of new things",
                R.drawable.aimonitors
            )
            SocBoxes("Android Development Workshop",
                "Android development hour with Ben Kadel",
                R.drawable.main_comp_hub)
        }
        Text(text = "Upcoming Today",
            fontSize = 20.sp,
            color = Color.Black,
            modifier=Modifier.padding(top = 10.dp))
        MiniSocBoxes("Python for Data Anlysis", "30")
        MiniSocBoxes("Career Fair: Tech 2024", "56")
        MiniSocBoxes("E-Sports Gaming Night", "43")
    }
}
@Preview
@Composable
fun EventsPreview() {
    Events()
}
