package com.evinsavasli.hotel_booking1

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.evinsavasli.hotel_booking1.data.Hotel
import com.evinsavasli.hotel_booking1.ui.theme.HomeScreen
import com.evinsavasli.hotel_booking1.ui.theme.Hotel_Booking1Theme
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
fun MyNavigation(navHostController:NavHostController) {


    NavHost(
        navController = navHostController,
        startDestination = "login_flow",
    ) {
       navigation(startDestination = Route.LoginScreen().name,
            route = "login_flow") {


            composable(route = Route.LoginScreen().name) {
                LoginScreen(
                    onLoginClick = {
                        navHostController.navigate(
                            Route.HomeScreen().name
                        ){
                           popUpTo(route="login_flow")
                        }
                    },
                    onSignUpClick = {
                        navHostController.navigateToSingleTop(
                            Route.SignUpScreen().name
                        )

                    }
                )
            }
            composable(route = Route.SignUpScreen().name) {
                SignUpScreen(
                    onSignUpClick = {
                        navHostController.navigate(
                            Route.HomeScreen().name
                        ){
                            popUpTo(route="login_flow")
                        }
                    },
                    onLoginClick = {
                        navHostController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    },
                    onPrivacyClick = {
                        navHostController.navigate(
                            Route.PrivacyScreen().name
                        ){
                            launchSingleTop=true
                        }
                    },
                    onPolicyClick = {
                        navHostController.navigate(
                            Route.PolicyScreen().name
                        ){
                            launchSingleTop=true
                        }
                    }


                )

            }
            composable(route = Route.PrivacyScreen().name) {
                PrivacyScreen {
                    navHostController.navigateUp()
                }
            }
            composable(route = Route.PolicyScreen().name) {

                PolicyScreen {
                    navHostController.navigateUp()
                }

            }


        }
        composable(route = Route.HomeScreen().name) {
            HomeScreen(navigateToProfile = {hotel->

            })


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
     MyNavigation(navHostController = NavHostController(LocalContext.current))
    }
}
