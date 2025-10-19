package com.jotadev.doctoryaapp.presentation.medical_appointment

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jotadev.doctoryaapp.presentation.medical_appointment.components.ItemAppointment

@Composable
fun MedicalAppointmentScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewmodel: MedicalAppointmentViewModel = viewModel()
) {
    val state = viewmodel.state

    LaunchedEffect(key1 = Unit) {
        viewmodel.getMedicalAppointments()
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        if(state.isLoading){
            CircularProgressIndicator()
        }
    }

    Column(modifier = modifier.fillMaxSize().padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            state.appointments?.let {  appointments ->

                items(appointments){ appointment ->
                    ItemAppointment(
                        appointment = appointment
                    )
                }

            }



        }
    }




}