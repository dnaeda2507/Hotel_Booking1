package com.evinsavasli.hotel_booking1.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.evinsavasli.hotel_booking1.HotelListItem
import com.evinsavasli.hotel_booking1.data.Hotel

@Composable
fun SearchScreen(navController: NavController, hotels: List<Hotel>) {
    Column {
        Text(
            text = "Search Results",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            items(hotels.size) { index ->
                val hotel = hotels[index]
                HotelListItem(hotel = hotel) {
                    navController.navigate("HotelDetail/${hotel.id}")
                }
            }
        }
    }
}



