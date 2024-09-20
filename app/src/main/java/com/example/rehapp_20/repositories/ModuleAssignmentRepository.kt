package com.example.rehapp_20.repositories

import com.example.rehapp_20.apiservice.ModuleAssignmentApiService
import com.example.rehapp_20.models.ModuleAssignmentDTO
import com.example.rehapp_20.models.ModuleDTO
import retrofit2.Response
import javax.inject.Inject

class ModuleAssignmentRepository @Inject constructor (
    private val moduleAssignmentApiService: ModuleAssignmentApiService
) {

    suspend fun assignModuleToPatient(moduleAssignmentDTO: ModuleAssignmentDTO): Response<ModuleAssignmentDTO> {
        return moduleAssignmentApiService.assignModuleToPatient(moduleAssignmentDTO)
    }

    suspend fun getAssignedModulesByUserId(userId: Long): Response<List<ModuleDTO>> {
        return moduleAssignmentApiService.getAssignedModulesByUserId(userId)
    }

}