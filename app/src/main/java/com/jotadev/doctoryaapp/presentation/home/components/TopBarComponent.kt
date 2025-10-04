package com.jotadev.doctoryaapp.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jotadev.doctoryaapp.presentation.components.TextComponentBasic
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    modifier: Modifier = Modifier,
    title:String
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            TextComponentBasic(
                modifier = Modifier.padding(start = 4.dp),
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        /*colors = TopAppBarDefaults.topAppBarColors(
             containerColor = PrimaryColor,
             titleContentColor = Color.White
        ),*/
        actions = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                //tint = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                //tint = Color.White,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    )

}