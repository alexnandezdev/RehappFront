package com.example.rehapp_20.repositories

import android.util.Log
import com.example.rehapp_20.apiservice.UserApiService
import com.example.rehapp_20.models.PatientUserRegisterDTO
import com.example.rehapp_20.models.UserDTO
import retrofit2.Response
import javax.inject.Inject

class UserRepository@Inject constructor(
    private val userApiService: UserApiService
) {

    private val TAG = "UserRepository"

    suspend fun registerUser(user: PatientUserRegisterDTO): Response<PatientUserRegisterDTO> {
        return try {
            val response = userApiService.createUser(user)
            Log.d(TAG, "registerUser: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "registerUser: Error durante el registro de usuario", e)
            throw e
        }
    }

    suspend fun loginUser(email: String, password: String): Response<UserDTO> {
        return try {
            val response = userApiService.loginUser(email, password)
            Log.d(TAG, "loginUser: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "loginUser: Error durante el login de usuario", e)
            throw e
        }
    }

    suspend fun updateUser(user: UserDTO): Response<UserDTO> {
        return try {
            val response = userApiService.updateUser(user)
            Log.d(TAG, "updateUser: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "updateUser: Error durante la actualización del usuario", e)
            throw e
        }
    }

    suspend fun findPatientByIdentificationNumber(identificationNumber: String): Response<UserDTO> {
        return try {
            val response = userApiService.findPatientByIdentificationNumber(identificationNumber)
            Log.d(TAG, "findPatientByIdentificationNumber: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "findPatientByIdentificationNumber: Error durante la búsqueda del paciente", e)
            throw e
        }
    }
}