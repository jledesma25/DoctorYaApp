package com.jotadev.doctoryaapp.data

import com.google.gson.annotations.SerializedName

data class User2(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("userName") val userName:String,
    @SerializedName("email") val email:String
)