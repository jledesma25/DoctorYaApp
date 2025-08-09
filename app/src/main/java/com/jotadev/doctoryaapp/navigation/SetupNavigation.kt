package com.jotadev.doctoryaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.jotadev.doctoryaapp.presentation.on_boarding.OnBoardingScreen
import com.jotadev.doctoryaapp.presentation.sign_in.SignInScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = OnBoarding
    ){
        composable<OnBoarding> {
            OnBoardingScreen(
                onNavigation = {
                    navController.navigate(SignIn)
                }
            )
        }
        composable<SignIn> {
            SignInScreen()
        }
    }

}