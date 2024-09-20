package com.example.rehapp_20.repositories

import android.util.Log
import com.example.rehapp_20.apiservice.PhysioApiService
import com.example.rehapp_20.models.AssignPatientDTO
import com.example.rehapp_20.models.PhysioUserRegisterDTO
import retrofit2.Response
import javax.inject.Inject

class PhysioRepository @Inject constructor(
    private val physioApiService: PhysioApiService
) {

    private val TAG = "PhysioRepository"

    suspend fun registerPhysio(user: PhysioUserRegisterDTO): Response<PhysioUserRegisterDTO> {
        return try {
            val response = physioApiService.registerPhysiotherapist(user)
            Log.d(TAG, "registerPhysio: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "registerPhysio: Error durante el registro de fisioterapeuta", e)
            throw e
        }
    }

    suspend fun assignPatient(assignPatientDTO: AssignPatientDTO): Response<String> {
        return try {
            val response = physioApiService.assignPatientToPhysiotherapist(assignPatientDTO)
            Log.d(TAG, "assignPatient: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "assignPatient: Error asignando paciente", e)
            throw e
        }
    }
}