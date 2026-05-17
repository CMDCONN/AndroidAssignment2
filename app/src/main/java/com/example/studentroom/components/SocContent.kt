package com.example.studentroom.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentroom.R
import com.example.studentroom.data.SocProfile

@Composable
fun SocContent(socProfile: SocProfile, alignment: Alignment.Horizontal){
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = alignment
    ) {
        Text( text = socProfile.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text( text = socProfile.desc, fontWeight = FontWeight.Bold, fontSize = 10.sp, lineHeight = 10.sp)
    }
}

@Preview
@Composable
fun SocContentPreview(){
    SocContent(
        socProfile = SocProfile(1, "funtime", "Hello", R.drawable.lifedrawing),
        alignment = Alignment.Start
    )
}