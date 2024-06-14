package com.evinsavasli.hotel_booking1.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.evinsavasli.hotel_booking1.data.Hotel


@Composable
fun HotelDetailScreen(hotel: Hotel,navController: NavController) {

    Column(modifier = Modifier.padding(30.dp)) {
        Image(
            painter = painterResource(id = hotel.hotelImageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = hotel.hotelName, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Address: ${hotel.address}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Price Per Night: ${hotel.pricePerNight}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Description: ${hotel.description}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Rating: 4.0/5 ★★★★☆", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Comments: Great place to stay!", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(24.dp))
        BookNowButton(hotel.id, navController)
    }

}


@Composable
fun BookNowButton(hotelId: Int, navController: NavController) {
    Button(
        onClick = {
            navController.navigate("Booking/$hotelId")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Book Now")
    }
}

