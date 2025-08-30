package com.jotadev.doctoryaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jotadev.doctoryaapp.data.Api
import com.jotadev.doctoryaapp.data.User
import com.jotadev.doctoryaapp.navigation.SetupNavigation
import com.jotadev.doctoryaapp.ui.theme.DoctorYaAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        GlobalScope.launch(Dispatchers.Main) {

            val response = withContext(Dispatchers.IO) {
                Api.build().getUsers()
            }
            if (response.isSuccessful) {

                val users = response.body()
                users?.forEach { user ->
                    println("Id: ${user.id} - Name: ${user.name} - UserName: ${user.userName} - Email: ${user.email}")
                }

            } else {
                println(response.message())
            }


        }




        setContent {
            DoctorYaAppTheme {
                SetupNavigation()
            }
        }

    }
}

