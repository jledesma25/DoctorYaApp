package com.jotadev.doctoryaapp.data.model

import com.google.gson.annotations.SerializedName

//Todas las clases que me ayudarán a recibir información

data class UserDto(
    @SerializedName("message") val message:String,
    @SerializedName("_id") val id:String,
    @SerializedName("nombre") val name:String,
    @SerializedName("correo") val email:String,
    @SerializedName("token") val token:String
)
