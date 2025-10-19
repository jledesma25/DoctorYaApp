package com.jotadev.doctoryaapp.data

import com.jotadev.doctoryaapp.data.model.AppointmentDto
import com.jotadev.doctoryaapp.data.model.SignInRequest
import com.jotadev.doctoryaapp.data.model.UserDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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

        //
        @GET("patients/{userId}/appointments")
        suspend fun getAppointments(
            @Header("Authorization") token:String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2OGM4NDE4NjI4MzQ1OGJjYjg4ODljOSIsImlhdCI6MTc2MDg5MTU4MiwiZXhwIjoxNzYwODk1MTgyfQ.Oy8ufi4-D4pTFGFCrgls-4tkg4p-TrYM04sJnUCPtRo",
            @Path("userId") userId:String //66b63e4b4cd409a8dbb48038
        ): Response<List<AppointmentDto>>

    }


    //3. Consumir los metodos
    fun build(): Methods{
        return retrofit.create(Methods::class.java)
    }

}