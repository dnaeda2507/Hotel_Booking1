package com.evinsavasli.hotel_booking1.ui.theme.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PrivacyScreen(onBtnClick: () -> Unit) {
    Box(Modifier.fillMaxSize(), 
        contentAlignment = Alignment.Center){
        Column {
            Text(text = "Privacy Screen")
            Button(onClick = onBtnClick) {
                Text("Finish")
                
            }
        }
    }  
}