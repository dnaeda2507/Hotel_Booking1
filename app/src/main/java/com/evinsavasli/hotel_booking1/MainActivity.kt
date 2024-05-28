package com.evinsavasli.hotel_booking1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.evinsavasli.hotel_booking1.ui.theme.HomeScreen
import com.evinsavasli.hotel_booking1.ui.theme.Hotel_Booking1Theme
import com.evinsavasli.hotel_booking1.ui.theme.login.LoginScreen
import com.evinsavasli.hotel_booking1.ui.theme.signup.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Hotel_Booking1Theme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    MyNavigation(navController)
                }
            }
        }

    }
}

