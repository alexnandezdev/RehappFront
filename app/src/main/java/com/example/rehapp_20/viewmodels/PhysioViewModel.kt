package com.example.rehapp_20.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rehapp_20.models.AssignPatientDTO
import com.example.rehapp_20.models.PhysioUserRegisterDTO
import com.example.rehapp_20.repositories.PhysioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PhysioViewModel @Inject constructor(
    private val physioRepository: PhysioRepository
) : ViewModel() {

    private val _registrationResult = MutableLiveData<Response<PhysioUserRegisterDTO>>()
    val registrationResult: LiveData<Response<PhysioUserRegisterDTO>> = _registrationResult

    private val _assignPatientResult = MutableLiveData<Response<String>>()
    val assignPatientResult: LiveData<Response<String>> = _assignPatientResult

    private val TAG = "PhysioViewModel"

    fun registerPhysio(user: PhysioUserRegisterDTO) {
        Log.d(TAG, "registerPhysio: Iniciando registro de fisioterapeuta con DTO: $user")
        viewModelScope.launch {
            try {
                val response = physioRepository.registerPhysio(user)
                Log.d(TAG, "registerPhysio: Respuesta del servidor: $response")
                _registrationResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "registerPhysio: Error durante el registro de fisioterapeuta", e)
            }
        }
    }

    fun assignPatient(physiotherapistId: Long, patientId: Long) {
        viewModelScope.launch {
            try {
                val response =physioRepository.assignPatient(
                    AssignPatientDTO(
                        physiotherapistId = physiotherapistId,
                        patientId = patientId
                    )
                )
                _assignPatientResult.postValue(response)
            } catch (e: Exception) {
                Log.e("PhysiotherapistViewModel", "Error asignando paciente: $e")
            }
        }
    }
}