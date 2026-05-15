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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.studentroom.R

@Composable
fun Socs() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ) {
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
        ){
            SocBoxes("Quantum Computing Club", "Leading research-driven society focused on next-gen computational architectures.", imageIn = R.drawable.aimonitors)
            SocBoxes("Life Drawing society","A community forged around drawing and love for each-other.", imageIn = R.drawable.lifedrawing)

        }
        Text(text = "DIRECTORY",
            color = Color(red = 0, green = 106, blue = 97),
            modifier = Modifier.padding(top=40.dp)
        )

        Text(
            text = "All Societies",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
        )

        Column(modifier = Modifier
            .padding(top=10.dp)

        ) {
            MiniSocBoxes("Data Science Alliance", "420")
            MiniSocBoxes("Spooky Season", "69")
            MiniSocBoxes("Technological Terror", "120")
        }
    }
}



@Composable
fun SocBoxes(titleText: String, paraText: String, imageIn: Int? = null){
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(450.dp)
            .padding(top = 20.dp)
            .border(1.dp, Color.Gray)
            .background(color = Color(255, 255, 255))
    ){
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
            Text( text = paraText, color = Color.Black ,modifier = Modifier.padding(top = 5.dp) )

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = {}, modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ), shape = RectangleShape){
                Text("APPLY FOR MEMBERSHIP")
            }

        }
    }
}

@Composable
fun MiniSocBoxes(titleText: String, members: String){
    Box(modifier = Modifier.fillMaxWidth().padding(top=10.dp).height(75.dp).border(width = 1.dp, color = Color.Gray).background(color = Color.White)){

        Column(modifier = Modifier.padding(10.dp)) {
            Text( text =  titleText, fontSize = 20.sp, color = Color.Black)
            Text( text = members + " Members", fontSize = 10.sp, color = Color.Black)
        }
// Icon Was generated with ai using the gemini-3-flash-preview model where the prompt was Context + "how do i put an arrow pointing to the right at the very right middle side of the minisocboxes composable"
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Navigate",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 15.dp),
            tint = Color.Black
        )

    }
}



@Preview
@Composable
fun SocsPreview() {
    Socs()
}
