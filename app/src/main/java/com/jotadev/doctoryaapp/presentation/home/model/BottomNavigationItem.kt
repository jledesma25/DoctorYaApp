package com.jotadev.doctoryaapp.presentation.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.PermContactCalendar
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title:String,
    val icon: ImageVector
)

fun getItemsNavigation() : List<BottomNavigationItem> {
    return listOf(
        BottomNavigationItem(
            title = "Perfil",
            icon = Icons.Filled.PermContactCalendar
        ),
        BottomNavigationItem(
            title = "Mis Citas",
            icon = Icons.Filled.FormatListNumbered
        ),
        BottomNavigationItem(
            title = "Historial",
            icon = Icons.Filled.AddToQueue
        ),
        BottomNavigationItem(
            title = "Configuración",
            icon = Icons.Filled.Settings
        )
    )
}
