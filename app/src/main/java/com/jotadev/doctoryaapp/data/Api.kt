package com.jotadev.doctoryaapp.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Api {

    //Configurar Retrofit

    //https://jsonplaceholder.typicode.com/users/2

    //URL_BASE: https://jsonplaceholder.typicode.com/
    //RECURSO: users/2

    //1. Configurar retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //2. Definir Metodos
    interface Methods{

        @GET("users")
        suspend fun getUsers() : Response<List<User>>
    }


    //3. Consumir los metodos
    fun build(): Methods{
        return retrofit.create(Methods::class.java)
    }

}