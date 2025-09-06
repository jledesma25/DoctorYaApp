package com.jotadev.doctoryaapp.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jotadev.doctoryaapp.data.Api
import com.jotadev.doctoryaapp.data.model.SignInRequest
import com.jotadev.doctoryaapp.data.model.UserDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {

    var state by mutableStateOf(SignInState())
      private set

    fun signIn(email:String, password:String){

        viewModelScope.launch { //Dispatchers.Main

            state = state.copy(isLoading = true)

            val response = withContext(Dispatchers.IO){
                Api.build().signIn(
                    SignInRequest(
                        correo = "postman@gmail.com",
                        clave = "12345"
                    )
                )
            }

            if(response.isSuccessful){
                //val user = response.body()
                //println("Usuario: ${user?.name}")
                state = state.copy(user = response.body(), error = null, isLoading = false)
            }else{
                state = state.copy(error = response.message())
            }

            //state = state.copy(isLoading = false)
        }

    }
}

data class SignInState(
    val isLoading: Boolean = false, //true = Mostrar progress , false = ocultar progress
    val error: String? = null, //null = No hay error , "Error de conexion" = Mostrar error
    val user: UserDto? = null //null = No hay usuario , UserDto = Mostrar usuario
)

