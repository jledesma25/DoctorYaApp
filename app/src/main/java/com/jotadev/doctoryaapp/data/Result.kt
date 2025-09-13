package com.jotadev.doctoryaapp.data

import com.jotadev.doctoryaapp.data.model.UserDto

sealed class Result<T>(val data: T?=null,val message:String?=null) {

    //RAMAS o POSIBLES CAMINOS

    //1. Satisfactorio
    class Success<T>(data: T?) : Result<T>(data = data)

    //2. Error
    class Error<T>(message: String) : Result<T>(message = message)

}

