package com.evinsavasli.hotel_booking1.data

import com.evinsavasli.hotel_booking1.R

object Provider {

    val hotelList = listOf(
        Hotel(
            id = 1,
            hotelName = "Beachfront Resort & Spa",
            address = "Bodrum, Muğla",
            pricePerNight ="\$200 per night",
            description = "Experience luxury and tranquility at Beachfront Resort & Spa, where modern design meets stunning ocean views." +
                    "Enjoy our pools, world-class dining, and rejuvenating spa services.",
            hotelImageId = R.drawable.hotel1_1
        ),
        Hotel(
            id = 2,
            hotelName = "Mountain Lodge Hotel",
            address = "Uludağ, Bursa",
            pricePerNight = "\$150 per night",
            description = "Nestled at the base of majestic mountains, Mountain Lodge Hotel offers a rustic yet comfortable retreat." +
                    "Ideal for hiking, biking, and winter skiing, it’s perfect for nature lovers.",
            hotelImageId = R.drawable.hotel1_1
        ),
        Hotel(
            id = 3,
            hotelName = "City Center Hotel",
            address = "Bodrum, Muğla",
            pricePerNight = "\$180 per night",
            description = "Located in the heart of downtown, City Center Hotel is perfect for business and leisure travelers." +
                    " Modern rooms, high-speed internet, and close proximity to major attractions.",
            hotelImageId = R.drawable.hotel1_1
        ),
        Hotel(
            id = 4,
            hotelName = "Historic Manor Hotel",
            address = "Taksim, Istanbul",
            pricePerNight ="$180 per night",
            description = "Step back in time at Historic Manor Hotel, a beautifully restored Ottoman-era building." +
                    " Enjoy antique furnishings, a serene courtyard, and a rich breakfast buffet.",
            hotelImageId = R.drawable.hotel1_1
        ),
        Hotel(
            id = 5,
            hotelName = "Eco-Lodge Hotel",
            address = "Sultanahmet, Istanbul",
            pricePerNight ="\$130 per night",
            description = "Eco-Lodge Hotel combines comfort with sustainability." +
                    "Stay in wooden bungalows, savor organic meals, and immerse yourself in nature's tranquility.",
            hotelImageId = R.drawable.hotel1_1
        ),
        Hotel(
            id = 6,
            hotelName = "Boutique Luxury Hotel",
            address = "Alaçatı, İzmir",
            pricePerNight = "\$220 per night",
            description = "Boutique Luxury Hotel offers elegance and opulence in every detail." +
                    "   Indulge in stylish rooms, personalized service, and a lavish ambiance.",
            hotelImageId = R.drawable.hotel1_1
        ),


        )
}