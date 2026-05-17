package com.example.studentroom.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.studentroom.R
import com.example.studentroom.data.SocProfile

@Composable
fun SocPicture(socProfile: SocProfile, socPicSize: Dp){
    Card(
        shape = CircleShape,
        border = BorderStroke(width=2.dp,
            color = Color.Black),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = painterResource(socProfile.imageResourceId),
            contentDescription = "Profile picture of ${socProfile.name}",
            modifier = Modifier.size(socPicSize),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview
@Composable
fun ProfilePicturePreview() {
    SocPicture(
        socProfile = SocProfile(1, "Ethel Mathews", "Hello", R.drawable.lifedrawing),
        socPicSize = 50.dp
    )
}