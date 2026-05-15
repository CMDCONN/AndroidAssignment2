package com.example.studentroom.screens


import android.graphics.Color.alpha
import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "ENROLLMENT DETAILS", color = Color(red = 0, green = 106, blue = 97))
        Text(
            text = "BSc Computer Science",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
        )
        CurrentStats()
        AwardBoxes("ACADEMIC YEAR", "Year 2", "Semester 2 in progress", col1 = Color.Black, col2 = Color.Black, col3 = Color(red = 0, green = 106, blue = 97))
        AwardBoxes("NEXT MILESTONE", "Dissertation Proposal", "Due in 14 days", col3 = Color(203, 76, 78))
        AwardBoxes("STATUS", "ACTIVE", "Full-Time enrollment", col3= Color.Black)

        HorizontalDivider(modifier = Modifier.padding(top = 15.dp))

        Row(){
            Text(
                text = "Current Enrolled Modules",
                color = Color.Black,
                fontSize = 25.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        CurrentModuleBox("CS201", "Data Structures & Algorithms", CompletionNum = "40%", CompletionPer = 0.4f , paraText =  "Fundamental data structures,sorting and algorithmic complexity analysis with a focus on C++ implementation.")
        CurrentModuleBox("CS205", "Distributed Systems",CompletionNum = "30%", CompletionPer = 0.3f , paraText = "Concepts of parallel processing, network protocols, and distributed database management in modern cloud computing")
        CurrentModuleBox("CS108", "Introduction to AI", "Search algorithms, logic-based agents and basic machine learning concepts for modern robotics.", CompletionPer = 0.95f, CompletionNum = "95%")


    }
}

@Composable
fun CurrentStats() {
    Row(modifier = Modifier
        .padding(top = 10.dp)
        .fillMaxWidth()
        .padding(3.dp)
        .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
        .background(color = Color(255, 255, 255))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Text("CURRENT TRACK", fontSize = 15.sp, color = Color.Black,)
            Text("1st", fontSize = 25.sp, color = Color.Black,)
        }


        VerticalDivider()


        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Text("CREDITS", fontSize = 15.sp, color = Color.Black,)
            Text("180 / 360", fontSize = 25.sp, color = Color.Black,)
        }
    }
}

@Composable
fun AwardBoxes(topText: String, titleText: String, paraText: String, col1: Color? = null, col2: Color? = null, col3: Color? = null){
    Box(
        modifier = Modifier.fillMaxWidth().padding(top=20.dp).border(1.dp, Color.Gray).background(color = Color(255, 255, 255))
    ){
        Column(modifier = Modifier.padding(15.dp)) {
            if (col1 == null){
                Text( text = topText, color = Color.Black)
            }
            else{
                Text( text = topText, color = col1)
            }

            if (col2 == null){
                Text( text = titleText,
                    color = Color.Black,
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)))
            }
            else{
                Text( text = titleText,
                    color = col2,
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)))

            }

            if (col3 == null){
                Text( text = paraText,
                    color = Color(red = 0, green = 106, blue = 97),
                    modifier = Modifier.padding(top = 5.dp) )
            }
            else{
                Text( text = paraText,
                    color = col3,
                    modifier = Modifier.padding(top = 5.dp) )
            }


        }
    }
}


@Composable
fun CurrentModuleBox(topText: String, titleText: String, paraText: String, CompletionNum: String, CompletionPer: Float, col1: Color? = null, col2: Color? = null, col3: Color? = null){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=20.dp)
            .background(color = Color(255, 255, 255))
            .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))

    ){
        Column(modifier = Modifier.padding(15.dp)) {
            if (col1 == null){
                Text( text = topText, color = Color.Black)
            }
            else{
                Text( text = topText, color = col1)
            }

            if (col2 == null){
                Text( text = titleText,
                    color = Color.Black,
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)))
            }
            else{
                Text( text = titleText,
                    color = col2,
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)))

            }

            if (col3 == null){
                Text( text = paraText,
                    color = Color(red = 0, green = 106, blue = 97),
                    modifier = Modifier.padding(top = 5.dp) )
            }
            else{
                Text( text = paraText,
                    color = col3,
                    modifier = Modifier.padding(top = 5.dp) )
            }
            ProgressBar(ProgressText = CompletionNum, ProgressP = CompletionPer)
        }
    }
}


@Composable
fun ProgressBar(ProgressText: String, ProgressP: Float){
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 15.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Text( text = "Unit Progress", color = Color.Black )
        Text( text = ProgressText, color = Color.Black )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(ProgressP)
                .fillMaxHeight()
                .background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun AltPreview() {
    Profile()
}
