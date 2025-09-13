package com.jotadev.doctoryaapp.domain.model

import com.jotadev.doctoryaapp.data.model.UserDto

data class User(
    val id:String,
    val name:String,
    val email:String
)

//EXTENSION FUNCTION

//UserDTO -> USER
fun UserDto.toModelDomain() : User{
    return User(
        id = this.id,
        name = this.name,
        email = this.email
    )
}