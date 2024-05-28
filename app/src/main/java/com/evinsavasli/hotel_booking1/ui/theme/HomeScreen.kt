package com.evinsavasli.hotel_booking1.ui.theme

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evinsavasli.hotel_booking1.HotelListItem
import com.evinsavasli.hotel_booking1.ProfileActivity
import com.evinsavasli.hotel_booking1.ProfileDetail
import com.evinsavasli.hotel_booking1.data.Hotel
import com.evinsavasli.hotel_booking1.data.Provider

@Composable
fun HomeScreen(navigateToProfile: (Hotel) -> Unit) {
    val hotels = remember { Provider.hotelList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = hotels,
            itemContent = {
                HotelListItem(
                    hotel = it,
                    navigateToProfile
                )
            })
    }
}
@Composable
fun NavigateToProfile(hotel: Hotel) {
    val context = LocalContext.current
    val intent = ProfileActivity.newIntent(context,hotel)
    context.startActivity(intent)
}
@Preview(showBackground = true)
@Composable
fun PrevHomeScreen(){
    Hotel_Booking1Theme {
        HomeScreen({})
    }
}
