package com.example.rehapp_20.apiservice

import com.example.rehapp_20.models.ModuleDTO
import retrofit2.Response
import retrofit2.http.GET

interface ModuleApiService {

    @GET("/rehapp/module/getAllModules")
    suspend fun getAllModules(): Response<List<ModuleDTO>>

}