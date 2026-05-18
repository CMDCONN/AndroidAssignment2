package com.example.studentroom.screens


import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.studentroom.R

@Composable
fun Campus(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        FullSizedImageBox("Main Computing Hub", R.drawable.main_comp_hub)
        Text(
            text = "GEAR OPEN TO STUDENTS",
            color = Color(red = 0, green = 106, blue = 97),
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = "Campus Facilities",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable))
        )
        Text(
            text = "Real-time occuoancy and equipment inventory, for computing laboratories and specialized study environments across the campus.",
            fontSize = 15.sp, color = Color.DarkGray
        )
        BarButtons()
        ResourceBox(
            "Advanced AI Research Lab",
            "LAB_A-102",
            "24x NVIDIA RTX 4090 Workstations",
            "Linux Dev Environment",
            "40%",
            0.4f
        )
        ResourceBox(
            "Focused Coding Suite",
            "Zone_B-20",
            "High-Speed Power Hubs",
            "Gigabit Fiber WiFi",
            "95%",
            0.95f
        )
        ResourceBox(
            "Central IT Helpdesk",
            "TECH_SUPPORT",
            "Hardware Repairs & Software Support",
            "Poster Printing Station",
            "47%",
            0.47f
        )
        ResourceBox(
            "Distributed Systems Lab",
            "LAB_C-005",
            "Azure/AWS Sandbox Access",
            "Dual 4K Monitor Setups",
            "98%",
            0.98f
        )
        HorizontalDivider(modifier = Modifier.padding(top = 36.dp, bottom = 36.dp))
        Button(
            onClick = { navController.navigate("events") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
        ) {
            Text(text = "Click Here for all campus events!")
        }
        HorizontalDivider(modifier = Modifier.padding(top = 36.dp, bottom = 36.dp))
        NetworkInfraStatus()
    }
}

@Composable
fun FullSizedImageBox(contentDesc: String? = null, photoId: Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (contentDesc == null) {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = photoId),
                contentDescription = contentDesc
            )
        } else {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = photoId),
                contentDescription = contentDesc
            )
        }


    }
}


@Composable
fun BarButtons() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(top = 10.dp),
        Arrangement.spacedBy(4.dp)
    ) {

        ButtonNew(
            Color.White,
            Color.Black,
            "ALL ZONES"
        )
        ButtonNew(
            Color.White,
            Color.Black,
            "LABS"
        )
        ButtonNew(
            Color.White,
            Color.Black,
            "STUDY ZONES"
        )
        ButtonNew(
            Color.White,
            Color.Black,
            "SUPPORT"
        )
        Spacer(modifier = Modifier.size(20.dp))
    }
}



@Composable
fun ResourceBox(titleText: String, miniText: String, content1: String, content2: String, progress: String, persc: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(color = Color(255,255,255))
            .border(width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(top = 10.dp),
            Arrangement.spacedBy(0.dp)
        ) {
            Text(
                text = miniText,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0, 105, 97),
                modifier = Modifier
                    .padding(6.dp)
                    .background(color = Color(230, 251, 249))
            )
            Text(
                text = titleText,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(6.dp)
            )

        }
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon(
                    imageVector = Icons.Filled.Monitor,
                    contentDescription = "Info",
                    tint = Color.Black

                    )
                Text(text = content1, color = Color.Black)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon(
                    imageVector = Icons.Filled.Terminal,
                    contentDescription = "Info",
                    tint = Color.Black
                )
                Text(text = content2, color = Color.Black)
            }
            OccupancyBar(
                progress, persc
            )
        }
    }
}


@Composable
fun OccupancyBar(ProgressText: String, ProgressP: Float){
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 15.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Text( text = "Occupancy", color = Color.Black )
        Text( text = ProgressText + " Full", color = Color.Black )
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

@Composable
fun ButtonNew(
    contentCol: Color = Color.White,
    containerCol: Color = Color.Black,
    buttonText: String
) {
    Button(
        onClick = ({}),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerCol,
            contentColor = contentCol,
        )
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun NetworkInfraStatus(){
    Text( text = "NETWORK INFRASTRUCTURE STATUS",
        color = Color.LightGray,
        )

    Column(modifier=Modifier.padding(top = 10.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .height(100.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    RoundedCornerShape(0.dp))
            ){
                Column(modifier = Modifier.padding(10.dp)) {
                    Text( text = "Core Bandwidth", fontSize = 17.sp, color = Color.Gray)
                    Text( text = "10 Gbps", fontSize = 30.sp, color = Color.Black)
                }
            }
            Box(modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .height(100.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    RoundedCornerShape(0.dp))
            ){
                Column(modifier = Modifier.padding(10.dp)) {
                    Text( text = "Active Nodes", fontSize = 17.sp, color = Color.Gray)
                    Text( text = "1,422", fontSize = 30.sp, color = Color.Black)
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .height(100.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    RoundedCornerShape(0.dp))
            ){
                Column(modifier = Modifier.padding(10.dp)) {
                    Text( text = "Server Uptime", fontSize = 17.sp, color = Color.Gray)
                    Text( text = "99.99%", fontSize = 30.sp, color = Color(red = 0, green = 106, blue = 97))
                }
            }
            Box(modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .height(100.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    RoundedCornerShape(0.dp))
            ){
                Column(modifier = Modifier.padding(10.dp)) {
                    Text( text = "Avg Latency", fontSize = 17.sp, color = Color.Gray)
                    Text( text = "2ms", fontSize = 30.sp, color = Color.Black)
                }
            }
        }


    }
}


