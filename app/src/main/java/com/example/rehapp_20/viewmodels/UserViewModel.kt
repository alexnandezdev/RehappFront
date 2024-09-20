package com.example.rehapp_20.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rehapp_20.models.PatientUserRegisterDTO
import com.example.rehapp_20.models.UserDTO
import com.example.rehapp_20.repositories.UserRepository
import com.example.rehapp_20.utils.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _registrationResult = MutableLiveData<Response<PatientUserRegisterDTO>>()
    val registrationResult: LiveData<Response<PatientUserRegisterDTO>> = _registrationResult

    private val _loginResult = MutableLiveData<Response<UserDTO>>()
    val loginResult: LiveData<Response<UserDTO>> = _loginResult

    private val _updateResult = MutableLiveData<Response<UserDTO>>()
    val updateResult: LiveData<Response<UserDTO>> = _updateResult

    private val _patientSearchResult = MutableLiveData<Response<UserDTO>>()
    val patientSearchResult: LiveData<Response<UserDTO>> = _patientSearchResult

    private val TAG = "UserViewModel"

    fun registerUser(user: PatientUserRegisterDTO) {
        Log.d(TAG, "registerUser: Iniciando registro de usuario con DTO: $user")
        viewModelScope.launch {
            try {
                val response = userRepository.registerUser(user)
                Log.d(TAG, "registerUser: Respuesta del servidor: $response")
                _registrationResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "registerUser: Error durante el registro de usuario", e)
            }
        }
    }

    fun loginUser(email: String, password: String) {
        Log.d(TAG, "loginUser: Iniciando login con email: $email")
        viewModelScope.launch {
            try {
                val response = userRepository.loginUser(email, password)
                Log.d(TAG, "loginUser: Respuesta del servidor: $response")
                if (response.isSuccessful) {
                    response.body()?.let { user ->
                        Log.d("UserLogin", "Datos del usuario logueado: $user")
                        userPreferences.saveUser(user)
                    }
                }
                _loginResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "loginUser: Error durante el login de usuario", e)
            }
        }
    }

    fun updateUser(user: UserDTO) {
        Log.d(TAG, "updateUser: Iniciando actualización de usuario con DTO: $user")
        viewModelScope.launch {
            try {
                val response = userRepository.updateUser(user)
                Log.d(TAG, "updateUser: Respuesta del servidor: $response")
                if (response.isSuccessful) {
                    response.body()?.let { updatedUser ->
                        userPreferences.saveUser(updatedUser) // Guardar los datos actualizados
                    }
                }
                _updateResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "updateUser: Error durante la actualización de usuario", e)
            }
        }
    }

    fun findPatientByIdentificationNumber(identificationNumber: String) {
        viewModelScope.launch {
            try {
                val response = userRepository.findPatientByIdentificationNumber(identificationNumber)
                _patientSearchResult.postValue(response)
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error buscando paciente: $e")
            }
        }
    }

}