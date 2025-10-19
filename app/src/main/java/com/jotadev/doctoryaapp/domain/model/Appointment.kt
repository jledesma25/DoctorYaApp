package com.jotadev.doctoryaapp.domain.model

import com.jotadev.doctoryaapp.data.model.AppointmentDto

data class Appointment(
    val id:String,
    val date:String,
    val hour:String,
    val patient:String,
    val doctor:String,
    val office:String,
    val state:String,
    val specialty:String,
)

fun List<AppointmentDto>.toModelDomain(): List<Appointment>{
    return this.map {
        Appointment(
            id = it.id,
            date = it.date,
            hour = it.hour,
            patient = it.patient,
            doctor = it.doctor,
            office = it.office,
            state = it.state,
            specialty = it.specialty,
        )
    }
}