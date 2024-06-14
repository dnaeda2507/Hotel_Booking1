package com.evinsavasli.hotel_booking1


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.evinsavasli.hotel_booking1.data.hotels
import com.evinsavasli.hotel_booking1.ui.theme.HomeScreen
import com.evinsavasli.hotel_booking1.ui.theme.HotelDetailScreen
import com.evinsavasli.hotel_booking1.ui.theme.Hotel_Booking1Theme
import com.evinsavasli.hotel_booking1.ui.theme.SearchScreen
import com.evinsavasli.hotel_booking1.ui.theme.login.LoginScreen
import com.evinsavasli.hotel_booking1.ui.theme.signup.PolicyScreen
import com.evinsavasli.hotel_booking1.ui.theme.signup.PrivacyScreen
import com.evinsavasli.hotel_booking1.ui.theme.signup.SignUpScreen


sealed class Route{
   data class LoginScreen(val name:String="Login"):Route()
    data class SignUpScreen(val name:String="Signup"):Route()
    data class PrivacyScreen(val name:String="Privacy"):Route()
    data class PolicyScreen(val name:String="Policy"):Route()
    data class HomeScreen(val name:String="Home"):Route()

    }


@Composable
fun MyNavigation( ) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_flow",
    ) {
       navigation(startDestination = Route.LoginScreen().name,
            route = "login_flow") {


            composable(route = Route.LoginScreen().name) {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate( Route.HomeScreen().name
                        ){
                           popUpTo(route="login_flow"){ inclusive = true }
                        }
                    },
                    onSignUpClick = {
                        navController.navigateToSingleTop(
                            Route.SignUpScreen().name
                        )

                    }
                )
            }
            composable(route = Route.SignUpScreen().name) {
                SignUpScreen(
                    onSignUpClick = {
                        navController.navigate(
                            Route.HomeScreen().name
                        ){
                            popUpTo(route="login_flow"){ inclusive = true }
                        }
                    },
                    onLoginClick = {
                        navController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    },
                    onPrivacyClick = {
                        navController.navigate(Route.PrivacyScreen().name){
                            launchSingleTop=true
                        }
                    },
                    onPolicyClick = { navController.navigate(Route.PolicyScreen().name
                        ){
                            launchSingleTop=true
                        }
                    }

                )

            }
            composable(route = Route.PrivacyScreen().name) {
                PrivacyScreen { navController.navigateUp() }
            }
            composable(route = Route.PolicyScreen().name) {

                PolicyScreen { navController.navigateUp() }

            }
        }
        composable(Route.HomeScreen().name) { HomeScreen(navController) }

        composable("SearchResults") { SearchScreen(navController = navController, hotels = hotels) }

        composable("HotelDetail/{hotelId}") { backStackEntry ->
            val hotelId = backStackEntry.arguments?.getString("hotelId")?.toIntOrNull()
            val hotel = hotels.find { it.id == hotelId }
            hotel?.let { HotelDetailScreen(it, navController) }
        }

    composable("Booking/{hotelId}") { backStackEntry ->
        val hotelId = backStackEntry.arguments?.getString("hotelId")?.toIntOrNull()
        val hotel = hotels.find { it.id == hotelId }
        hotel?.let {
            PaymentScreen(onPayClicked = { /* Handle payment logic */ })
        }
    }
}


}

fun NavController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

}
@Preview(showBackground = true)
@Composable
fun PrevNavigation(){
    Hotel_Booking1Theme {
     MyNavigation()
    }
}
