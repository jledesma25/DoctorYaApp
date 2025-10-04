package com.jotadev.doctoryaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jotadev.doctoryaapp.navigation.SetupNavigation
import com.jotadev.doctoryaapp.ui.theme.DoctorYaAppTheme

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
