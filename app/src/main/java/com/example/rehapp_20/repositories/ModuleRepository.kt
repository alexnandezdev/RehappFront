package com.example.rehapp_20.repositories

import android.util.Log
import com.example.rehapp_20.apiservice.ModuleApiService
import com.example.rehapp_20.models.ModuleDTO
import retrofit2.Response
import javax.inject.Inject

class ModuleRepository @Inject constructor (
    private val moduleApiService: ModuleApiService
){

    private val TAG = "ModuleRepository"

    suspend fun getAllModules(): Response<List<ModuleDTO>> {
        return try {
            val response = moduleApiService.getAllModules()
            Log.d(TAG, "getAllModules: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "getAllModules: Error al obtener los módulos", e)
            throw e
        }
    }
}