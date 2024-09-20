package com.example.rehapp_20.apiservice

import com.example.rehapp_20.models.ModuleAssignmentDTO
import com.example.rehapp_20.models.ModuleDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ModuleAssignmentApiService {

    @POST("/rehapp/module-assignment/assign")
    suspend fun assignModuleToPatient(
        @Body moduleAssignmentDTO: ModuleAssignmentDTO
    ): Response<ModuleAssignmentDTO>

    @GET("/rehapp/module-assignment/user/{userId}/modules")
    suspend fun getAssignedModulesByUserId(
        @Path("userId") userId: Long
    ): Response<List<ModuleDTO>>

}