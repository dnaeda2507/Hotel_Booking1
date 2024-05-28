@file:Suppress("DEPRECATION")

package com.evinsavasli.hotel_booking1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.evinsavasli.hotel_booking1.data.Hotel
import com.evinsavasli.hotel_booking1.ui.theme.HomeScreen
import com.evinsavasli.hotel_booking1.ui.theme.Hotel_Booking1Theme


class ProfileActivity : ComponentActivity(

) {
    private val hotel: Hotel by lazy {
        intent?.getSerializableExtra(HOTEL_ID) as Hotel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hotel_Booking1Theme {
                ProfileDetail(hotel = hotel)
            }
        }
    }

    companion object {
        private const val HOTEL_ID = "hotel_id"
        fun newIntent(context: Context, hotel: Hotel) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(HOTEL_ID, hotel)
            }
    }


}