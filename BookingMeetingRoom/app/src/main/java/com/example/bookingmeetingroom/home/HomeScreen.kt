package com.example.bookingmeetingroom.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookingmeetingroom.R
import com.example.bookingmeetingroom.ui.theme.BookingMeetingRoomTheme
import com.example.bookingmeetingroom.ui.theme.LightGray200

class HomeScreen {



}

@Preview
@Composable
fun CardScreen() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .width(100.dp)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                ,
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Icon(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),

                imageVector = Icons.Filled.MeetingRoom,
                contentDescription = stringResource(id = R.string.back)
            )

            Text(
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.body2,
                text = "ایجاد جلسه"
            )


        }

    }
}

@Composable
fun ImageResource(imgResource: Int) {
    val image: Painter = painterResource(id = imgResource)
    Image(painter = image, contentDescription = "")
}
@Composable
fun MainScreen() {
    Scaffold(topBar = {  }) {
        Surface(
            modifier =
            Modifier.fillMaxSize(),
            color = LightGray200
        ) {
            Row {
                CardScreen()
            }

        }
    }

}