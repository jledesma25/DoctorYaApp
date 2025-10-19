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

data class AppointmentDto(
    @SerializedName("id") val id:String,
    @SerializedName("fecha") val date:String,
    @SerializedName("hora") val hour:String,
    @SerializedName("paciente") val patient:String,
    @SerializedName("doctor") val doctor:String,
    @SerializedName("consultorio") val office:String,
    @SerializedName("estado") val state:String,
    @SerializedName("especialidad") val specialty:String,
)
