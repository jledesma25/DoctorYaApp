package com.jotadev.doctoryaapp.domain.repository

import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.data.model.AppointmentDto
import com.jotadev.doctoryaapp.domain.model.Appointment

interface AppointmentRepository {

    suspend fun getMedicalAppointmentsByUserId(userId:String) : Result<List<Appointment>>

}