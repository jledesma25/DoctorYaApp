package com.jotadev.doctoryaapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.PermContactCalendar
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jotadev.doctoryaapp.presentation.home.components.TopBarComponent
import com.jotadev.doctoryaapp.presentation.home.model.BottomNavigationItem
import com.jotadev.doctoryaapp.presentation.home.model.getItemsNavigation
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {


    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBarComponent(
                title = "DoctorYa"
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent,
                contentColor = PrimaryColor,
                tonalElevation = 8.dp
            ) {
                getItemsNavigation().forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },
                        label = {
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center
                            )
                        },
                        alwaysShowLabel = true,
                        icon = {
                            Column {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "Icon Bottom Navigation"
                                )

                            }

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Gray
                        )
                    )
                }
            }

        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = { /* Acción al hacer clic en el botón */ },
                containerColor = PrimaryColor,
                contentColor = Color.White,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp
                )
            ){
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }

        }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text("Aqui se hará la pantalla del listado de categorias")
        }

    }
}