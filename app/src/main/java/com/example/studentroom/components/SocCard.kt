package com.example.studentroom.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentroom.R
import com.example.studentroom.data.SocProfile

@Composable
fun SocCard(socProfile: SocProfile, clickAction: (SocProfile) -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable { clickAction(socProfile) },
        shape = RectangleShape,

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            SocPicture(socProfile, 70.dp)
            SocContent(socProfile, Alignment.Start)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfileCard() {
    SocCard(
        socProfile = SocProfile(1, "Ethel Mathews", "Yo", R.drawable.lifedrawing),
        clickAction = { clickedProfile -> null }
    )
}