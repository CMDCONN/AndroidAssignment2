package com.example.studentroom.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studentroom.R
import com.example.studentroom.components.SocCard
import com.example.studentroom.data.SocProfile
import com.example.studentroom.data.socList

@Composable
fun Socs(socList: List<SocProfile>, navController: NavHostController) {
    Spacer(modifier = Modifier.size(20.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "FEATURED GROUPS", color = Color(red = 0, green = 106, blue = 97))
            Text(
                text = "Elite Societies",
                color = Color.Black,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
            )
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SocBoxes(
                    "Quantum Computing Club",
                    "Leading research-driven society focused on next-gen computational architectures.",
                    imageIn = R.drawable.aimonitors
                )
                SocBoxes(
                    "Life Drawing society",
                    "A community forged around drawing and love for each-other.",
                    imageIn = R.drawable.lifedrawing
                )

            }
            Text(
                text = "DIRECTORY",
                color = Color(red = 0, green = 106, blue = 97),
                modifier = Modifier.padding(top = 40.dp)
            )

            Text(
                text = "All Societies",
                color = Color.Black,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(socList) { soc ->
            SocCard(soc) {
                navController.navigate("socDetailsPage/${it.id}")
            }
        }

        item {
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}



@Composable
fun SocBoxes(titleText: String, paraText: String, imageIn: Int? = null) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(450.dp)
            .padding(top = 20.dp)
            .border(1.dp, Color.Gray)
            .background(color = Color(255, 255, 255))
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            if (imageIn != null) {
                Image(
                    painter = painterResource(id = imageIn),
                    contentDescription = "My drawable image",
                )
            }

            Text(
                text = titleText,
                color = Color.Black,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
            )
            Text(text = paraText, color = Color.Black, modifier = Modifier.padding(top = 5.dp))

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {}, modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ), shape = RectangleShape
            ) {
                Text("APPLY FOR MEMBERSHIP")
            }

        }
    }
}
