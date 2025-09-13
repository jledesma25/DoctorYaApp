package com.jotadev.doctoryaapp.domain.repository

import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.data.model.UserDto
import com.jotadev.doctoryaapp.domain.model.User

interface AuthRepository {

    //Que es lo que va a hacer mi repository
    suspend fun signIn(email:String,password:String) : Result<User>
}