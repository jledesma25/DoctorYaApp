package com.jotadev.doctoryaapp.data.repository

import com.jotadev.doctoryaapp.data.Api
import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.domain.model.Appointment
import com.jotadev.doctoryaapp.domain.model.toModelDomain
import com.jotadev.doctoryaapp.domain.repository.AppointmentRepository
import org.json.JSONObject
import java.io.IOException

class AppointmentRepositoryImp : AppointmentRepository {

    override suspend fun getMedicalAppointmentsByUserId(userId: String) : Result<List<Appointment>> {
        try{
            val response = Api.build()
                .getAppointments(
                    userId ="66b63e4b4cd409a8dbb48038"
                )

            if(response.isSuccessful){
                val data = response.body()
                return Result.Success(data = data?.toModelDomain() ?: emptyList())
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