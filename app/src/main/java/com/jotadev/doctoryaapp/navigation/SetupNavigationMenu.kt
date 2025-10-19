package com.jotadev.doctoryaapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jotadev.doctoryaapp.presentation.history.HistoryScreen
import com.jotadev.doctoryaapp.presentation.medical_appointment.MedicalAppointmentScreen
import com.jotadev.doctoryaapp.presentation.profile.ProfileScreen
import com.jotadev.doctoryaapp.presentation.settings.SettingScreen

@Composable
fun SetupNavigationMenu(
    navController: NavHostController,
    paddingValues: PaddingValues
){

    NavHost(
        navController = navController,
        startDestination = MedicalAppointments
    ){
        composable<Profile>{
            ProfileScreen()
        }
        composable<MedicalAppointments>{
            MedicalAppointmentScreen(paddingValues = paddingValues)
        }
        composable<History>{
            HistoryScreen()
        }
        composable<Settings>{
            SettingScreen()
        }
    }

}