package com.jotadev.doctoryaapp.data

import com.jotadev.doctoryaapp.data.model.SignInRequest
import com.jotadev.doctoryaapp.data.model.UserDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

object Api {

    //Configurar Retrofit

    //https://jsonplaceholder.typicode.com/users/2
    //https://jsonplaceholder.typicode.com/comments

    //URL_BASE: https://jsonplaceholder.typicode.com/
    //RECURSO: users

    //https://sistema-pacientes-backend-production-1efb.up.railway.app/users/login
    //https://sistema-pacientes-backend-production-1efb.up.railway.app/users
    //https://sistema-pacientes-backend-production-1efb.up.railway.app/users/668c84186283458bcb8889c9

    //1. Configurar retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://sistema-pacientes-backend-production-1efb.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //2. Definir Metodos
    interface Methods{

        @GET("users")
        //suspend fun getUsers() : Response<List<User>>
        suspend fun getUsers():List<User2>

        @POST("users/login")
        suspend fun signIn(@Body request: SignInRequest) : Response<UserDto?>
    }


    //3. Consumir los metodos
    fun build(): Methods{
        return retrofit.create(Methods::class.java)
    }

}