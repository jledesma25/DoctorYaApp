package com.jotadev.doctoryaapp.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.data.repository.AuthRepositoryImp
import com.jotadev.doctoryaapp.domain.model.User
import com.jotadev.doctoryaapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class SignInViewModel : ViewModel() {

    var state by mutableStateOf(SignInState())
      private set

    val repository : AuthRepository = AuthRepositoryImp()

    fun signIn(email:String, password:String){

        viewModelScope.launch { //Dispatchers.Main

            state = state.copy(isLoading = true)

            val response = withContext(Dispatchers.IO){
                repository.signIn(email,password)
            }

            when(response){
                is Result.Error -> {
                    state = state.copy(error = response.message, user = null, isLoading = false)
                }
                is Result.Success -> {
                    state = state.copy(user = response.data, error = null, isLoading = false)
                }
            }
        }

    }

    fun clearError(){
        state = state.copy(error = null)
    }
}

data class SignInState(
    val isLoading: Boolean = false, //true = Mostrar progress , false = ocultar progress
    val error: String? = null, //null = No hay error , "Error de conexion" = Mostrar error
    val user: User? = null //null = No hay usuario , User = Navegacion
)

