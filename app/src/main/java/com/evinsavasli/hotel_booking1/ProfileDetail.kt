package com.evinsavasli.hotel_booking1

import android.content.Intent
import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.evinsavasli.hotel_booking1.data.Hotel
import com.evinsavasli.hotel_booking1.ui.theme.Hotel_Booking1Theme
import com.evinsavasli.hotel_booking1.ui.theme.signup.SignUpScreen

@Composable
fun ProfileDetail(hotel: Hotel) {
    val scrollState = rememberScrollState()



    Column(modifier = Modifier.fillMaxSize()) {


        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    // TODO:


                    ProfileHeader(
                        hotel = hotel,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                    BookNowButton()
                    // ProfileContent
                    ProfileContent(
                        hotel = hotel,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )


                }
            }
        }




    }

}
@Composable
private fun ProfileHeader(
    hotel: Hotel,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = hotel.hotelImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
@Composable
private fun ProfileContent(hotel: Hotel, containerHeight: Dp) {
    Column {
        Title(hotel)
        ProfileProperty(stringResource(R.string.address), hotel.address)
        ProfileProperty(stringResource(R.string.pricePerNight), hotel.pricePerNight.toString())
        ProfileProperty(stringResource(R.string.Description), hotel.description)
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
        BookNowButton()
    }
}
@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(32.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Visible
        )
    }
}
@Composable
private fun Title(
   hotel: Hotel
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)) {
        Text(
            text = hotel.hotelName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PrevProfileDetail() {
    val exampleHotel = Hotel(
        id = 1,
        hotelName = "Beachfront Resort & Spa",
        address = "Bodrum, Muğla",
        pricePerNight = "\$200 per night",
        description = "Experience luxury and tranquility at Beachfront Resort & Spa," +
                "where modern design meets stunning ocean views.Enjoy our pools, world-class dining, and rejuvenating spa services.\".",
        hotelImageId = R.drawable.hotel1_1
    )
    Hotel_Booking1Theme {
        ProfileDetail(hotel = exampleHotel)
    }
}
@Composable
fun BookNowButton() {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { /* TODO: Add booking functionality */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Book Now")
        }
    }
}