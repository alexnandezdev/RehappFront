package com.example.rehapp_20.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rehapp_20.models.ModuleAssignmentDTO
import com.example.rehapp_20.models.ModuleDTO
import com.example.rehapp_20.repositories.ModuleAssignmentRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ModuleAssignmentViewModel @Inject constructor(
    private val moduleAssignmentRepository: ModuleAssignmentRepository
) : ViewModel() {

    private val TAG = "ModuleAssignmentViewModel"

    private val _assignedModules = MutableLiveData<Response<List<ModuleDTO>>>()
    val assignedModules: LiveData<Response<List<ModuleDTO>>> = _assignedModules

    private val _moduleAssignmentResult = MutableLiveData<Response<ModuleAssignmentDTO>>()
    val moduleAssignmentResult: LiveData<Response<ModuleAssignmentDTO>> = _moduleAssignmentResult

    fun assignModuleToPatient(moduleAssignmentDTO: ModuleAssignmentDTO) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Assigning module: ${moduleAssignmentDTO.moduleId} to patient: ${moduleAssignmentDTO.patientId}")
                val response = moduleAssignmentRepository.assignModuleToPatient(moduleAssignmentDTO)
                Log.d(TAG, "Module assignment response: $response")
                _moduleAssignmentResult.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "Error assigning module to patient", e)
            }
        }
    }

    fun getAssignedModulesByUserId(userId: Long) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Fetching assigned modules for userId: $userId")
                val response = moduleAssignmentRepository.getAssignedModulesByUserId(userId)
                Log.d(TAG, "Assigned modules response: $response")
                _assignedModules.postValue(response)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching assigned modules for userId: $userId", e)
            }
        }
    }

}