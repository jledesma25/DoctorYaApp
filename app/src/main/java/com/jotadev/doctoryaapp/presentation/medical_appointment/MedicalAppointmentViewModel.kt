package com.jotadev.doctoryaapp.presentation.medical_appointment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jotadev.doctoryaapp.data.Result
import com.jotadev.doctoryaapp.data.repository.AppointmentRepositoryImp
import com.jotadev.doctoryaapp.domain.model.Appointment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MedicalAppointmentViewModel : ViewModel() {

    var state by mutableStateOf(MedicalAppointmentState())
        private set

    val appointmentRepository = AppointmentRepositoryImp()

    fun getMedicalAppointments() {

        try {
            viewModelScope.launch {

                state = state.copy(isLoading = true)

                val response = withContext(Dispatchers.IO) {
                    appointmentRepository.getMedicalAppointmentsByUserId("66b63e4b4cd409a8dbb48038")
                }

                when(response){
                    is Result.Error<*> -> {
                        state = state.copy(isLoading = false, error = response.message, appointments = emptyList())
                    }
                    is Result.Success<*> -> {
                        state = state.copy(isLoading = false, appointments = response.data, error = null)
                    }
                }
            }
        } catch (ex: Exception) {
            state = state.copy(isLoading = false, error = ex.message, appointments = emptyList())
        }

    }
}

data class MedicalAppointmentState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val appointments: List<Appointment>? = emptyList()
)