package com.example.studentroom.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentroom.R

@Composable
fun Awards() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text( text = "DEPARTMENT OF COMPUTING", color = Color(red = 0, green = 106, blue = 97))
        Text(
            text = "Course Catalog",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
        )
        Text( text = "Explore our rigorous undergraduate and postgraduate offerings desgined for the next genereation of technical leaders and scholarly innovators.", Modifier.padding(vertical = 20.dp), fontSize = 20.sp, color = Color.Black )
        HorizontalDivider()
        ButtonRow()
        MainBox(
            "POSTGRAD",
            "Data science & AI",
            "Advanced computational methods and statistical modeling for complex decision-making in the age of big data. This program focuses on neural networks, machine learning architectures, and ethical AI implementation.",
            R.drawable.computer_screen
        )
        MainBox(
            "UNDERGRAD",
            "Software Engineering",
            "Master the full software development lifecycle using industry-standard engineering principles and architectural patterns."
        )
        MainBox(
            "UNDERGRAD",
            "Cybersecurity",
            "A deep dive into network security, ethical hacking, and cryptographic protocols to protect digital infrastructures."
        )
        MainBox(
            "UNDERGRAD",
            "Computer Science",
            "Theoretical foundations of computation combined with practical applications in algorithms and system design."

        )

        Spacer(modifier = Modifier.size(20.dp))
    }
}



@Composable
fun ButtonRow(){
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(top = 20.dp),
        horizontalArrangement  = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )){
            Text("All Programs")
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )){
            Text("All Programs")
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )){
            Text("All Programs")
        }
    }
}

@Composable
fun MainBox(topText: String, titleText: String, paraText: String, imageIn: Int? = null){
    Box(
        modifier = Modifier.fillMaxWidth().padding(top=20.dp).border(1.dp, Color.Gray).background(color = Color(255, 255, 255))
    ){
        Column(modifier = Modifier.padding(15.dp)) {
            Text( text = topText, color = Color(red = 0, green = 106, blue = 97))
            Text(
                text = titleText,
                color = Color.Black,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
            )
            Text( text = paraText, color = Color.Black ,modifier = Modifier.padding(top = 5.dp) )
            Button(onClick = {}, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp) , colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ), shape = RectangleShape){
                Text("Learn More ->")
            }
            if (imageIn != null) {
                Image(
                    painter = painterResource(id = imageIn),
                    contentDescription = "My drawable image",
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}


@Preview
@Composable
fun AwardsPreview() {
    Awards()
}
