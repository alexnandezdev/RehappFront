package com.example.rehapp_20.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rehapp_20.models.ModuleDTO
import com.example.rehapp_20.repositories.ModuleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ModuleViewModel @Inject constructor(
    private val moduleRepository: ModuleRepository
) : ViewModel() {

    private val TAG = "ModuleViewModel"

    private val _modulesResult = MutableLiveData<Response<List<ModuleDTO>>>()
    val modulesResult: LiveData<Response<List<ModuleDTO>>> = _modulesResult

    fun fetchAllModules() {
        Log.d(TAG, "fetchAllModules: Iniciando la solicitud para obtener todos los módulos")
        viewModelScope.launch {
            try {
                val response = moduleRepository.getAllModules()
                Log.d(TAG, "fetchAllModules: Respuesta del servidor: $response")
                _modulesResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "fetchAllModules: Error al obtener los módulos", e)
            }
        }
    }
}