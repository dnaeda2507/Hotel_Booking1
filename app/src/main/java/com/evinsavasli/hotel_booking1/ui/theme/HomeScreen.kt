package com.evinsavasli.hotel_booking1.ui.theme

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.Calendar
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.evinsavasli.hotel_booking1.HotelListItem

import com.evinsavasli.hotel_booking1.data.hotels


@Composable
fun HomeScreen(navController: NavController) {
    Column {
        SearchBar {
            navController.navigate("SearchResults")
        }
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


@Composable
fun SearchBar(onSearchClicked: () -> Unit) {
    var destination by remember { mutableStateOf("") }
    var departDate by remember { mutableStateOf("") }
    var returnDate by remember { mutableStateOf("") }

    val context = LocalContext.current

    fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
            onDateSelected("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day).show()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = destination,
                onValueChange = { destination = it },
                label = { Text("Where do you want to go next?") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = departDate,
                    onValueChange = { departDate = it },
                    label = { Text("Depart On") },
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            showDatePickerDialog { date -> departDate = date }
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = returnDate,
                    onValueChange = { returnDate = it },
                    label = { Text("Return On") },
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            showDatePickerDialog { date -> returnDate = date }
                        }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onSearchClicked,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Search")
            }
        }
    }
}




