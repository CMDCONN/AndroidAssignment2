package com.example.studentroom.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Food() {
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { _ -> }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(248, 249, 255))
            .padding(start = 25.dp, end = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Campus Eats",
            color = Color.Black,
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_variable)),
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "Curated nutritional hubs for peak cognitive performance. Filter by budget and proximity.",
            Modifier.padding(vertical = 20.dp),
            fontSize = 15.sp,
            color = Color.Black
        )
        //https://developer.android.com/develop/ui/compose/components/search-bar
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            placeholder = { Text(text = "SEARCH FACILITIES...") },
            shape = RectangleShape,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            }
        ) {}
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterButtons()
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { cameraLauncher.launch(null) }) {
                Icon(Icons.Default.PhotoCamera, contentDescription = "Take photo", tint = Color.Black)
            }
        }
        HorizontalDivider(modifier = Modifier.padding(10.dp))

        FoodBoxes("Cyber Cafe & Kitchen", "Precision-brewed espresso and nutrient-dense grain bowls for sustained focus.", distance = "200m . Bldg 4", imageIn = R.drawable.cafe_italy)
        FoodBoxes("Pizza Stop", "Come get the best pizza in town for the best prices for students.", "1.3m . ST3")
        FoodBoxes("The Java Cafe", "The best coffee in the nagbourhood, come down for class coffee and the best snacks", "345m . ST4")
        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Composable
fun FilterButtons(){
    Box( modifier = Modifier
        .padding(top=5.dp)
        .clip(shape = RoundedCornerShape(40.dp))) {
        Row(modifier = Modifier.padding(6.dp)) {
            Button(
                modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
                onClick = { },
                shape = RectangleShape,
                // Setting the background and content colors
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("$")
            }
            Button(
                modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
                onClick = { },
                shape = RectangleShape,
                // Setting the background and content colors
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("$$")
            }
            Button(
                modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
                onClick = { },
                shape = RectangleShape,
                // Setting the background and content colors
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("$$$")
            }
        }
    }
}



@Composable
fun FoodBoxes(titleText: String, paraText: String, distance: String, imageIn: Int? = null){
    Box(
        modifier = Modifier.fillMaxWidth().padding(top=20.dp).border(1.dp, Color.Gray).background(color = Color(255, 255, 255))
    ){
        Column(){
            if (imageIn != null) {
                Image(
                    painter = painterResource(id = imageIn),
                    contentDescription = "My drawable image",
                )
            }

            Text(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                text = titleText,
                color = Color.Black,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_variable),

                )
            )
            Text(text = paraText, color = Color.Black ,modifier = Modifier.padding(top = 5.dp, start = 10.dp) )
            HorizontalDivider(modifier = Modifier.padding(10.dp))

            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom= 20.dp)) {
                Text(text = "DISTANCE", color = Color(red = 0, green = 106, blue = 97), modifier=Modifier.padding(start = 5.dp) )
                Text( text = distance,color = Color.Black, modifier = Modifier.padding(top=3.dp, start = 5.dp))
            }
        }
    }
}



@Preview
@Composable
fun FoodPreview() {
    Food()
}
