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
import com.jotadev.doctoryaapp.data.model.SignInRequest
import com.jotadev.doctoryaapp.data.model.UserDto
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




        setContent {
            DoctorYaAppTheme {
                SetupNavigation()
            }
        }

    }
}

/*
GlobalScope.launch(Dispatchers.Main) {

            println("Hola")
            val response: List<User> = withContext(Dispatchers.IO){
                Api.build().getUsers()
            }
            response.forEach { user ->
                println(user.name)
            }
            println("Adios")
        }

 */

/*
 GlobalScope.launch(Dispatchers.Main) {

            println("Hola")
            val response = withContext(Dispatchers.IO){
                Api.build().signIn(
                    SignInRequest(
                        correo = "postman@gmail.com",
                        clave = "1234"
                    )
                )
            }

            if(response.isSuccessful){
                val user = response.body()
                println("Usuario: ${user?.name}")
            }else{
                println("Credenciales incorrectas")
            }

            println("Adios")
        }
 */
