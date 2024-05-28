package com.evinsavasli.hotel_booking1.data

import java.io.Serializable

data class Hotel(
    val id: Int,
    val hotelName: String,
    val address: String,
    val pricePerNight: String,
    val description: String,
    val hotelImageId: Int = 0
): Serializable
