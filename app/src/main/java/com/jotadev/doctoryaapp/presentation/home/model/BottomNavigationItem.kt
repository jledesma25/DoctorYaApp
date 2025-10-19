package com.jotadev.doctoryaapp.presentation.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.PermContactCalendar
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.jotadev.doctoryaapp.navigation.Profile

data class BottomNavigationItem(
    val title:String,
    val icon: ImageVector,
    val currentRoute: String
)

fun getItemsNavigation() : List<BottomNavigationItem> {
    return listOf(
        BottomNavigationItem(
            title = "Perfil",
            icon = Icons.Filled.PermContactCalendar,
            currentRoute = "com.jotadev.doctoryaapp.navigation.Profile"

        ),
        BottomNavigationItem(
            title = "Mis Citas",
            icon = Icons.Filled.FormatListNumbered,
            currentRoute = "com.jotadev.doctoryaapp.navigation.MedicalAppointments"
        ),
        BottomNavigationItem(
            title = "Historial",
            icon = Icons.Filled.AddToQueue,
            currentRoute = "com.jotadev.doctoryaapp.navigation.History"
        ),
        BottomNavigationItem(
            title = "Configuración",
            icon = Icons.Filled.Settings,
            currentRoute = "com.jotadev.doctoryaapp.navigation.Settings"
        )
    )
}
