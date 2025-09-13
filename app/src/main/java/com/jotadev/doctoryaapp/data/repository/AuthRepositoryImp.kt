package com.jotadev.doctoryaapp.data.repository

import com.jotadev.doctoryaapp.data.Api
import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.data.model.SignInRequest
import com.jotadev.doctoryaapp.data.model.UserDto
import com.jotadev.doctoryaapp.domain.model.User
import com.jotadev.doctoryaapp.domain.model.toModelDomain
import com.jotadev.doctoryaapp.domain.repository.AuthRepository
import org.json.JSONObject
import java.io.IOException

class AuthRepositoryImp : AuthRepository {

    override suspend fun signIn(
        email: String,
        password: String
    ): Result<User> {
        try {
            val response = Api.build().signIn(
                SignInRequest(
                    correo = email,
                    clave = password
                )
            )
            if(response.isSuccessful){
                //Exitoso - 200
                val data: UserDto? = response.body()
                return Result.Success(data = data?.toModelDomain())
            }else{
                //Advertencia o error
                val errorBody = response.errorBody()?.string() ?: "Unknow error"
                val errorMessage = try{
                    val json = JSONObject(errorBody ?: "{}")
                    json.optString("message","Unknow error")
                }catch (ex: Exception){
                    response.message()
                }
                when(response.code()){
                    401 -> return Result.Error(message = errorMessage)
                    else -> return Result.Error(message = response.message())
                }

            }
        }
        catch (ex: IOException){
            return Result.Error(message = "Compruebe su conexión a internet.")
        }
        catch (ex: Exception){
            return Result.Error(message = ex.message.toString())
        }
    }
}