package com.example.rehapp_20.repositories

import android.util.Log
import com.example.rehapp_20.apiservice.VideoApiService
import com.example.rehapp_20.models.VideoDTO
import retrofit2.Response
import javax.inject.Inject

class VideoRepository @Inject constructor(
    private val videoApiService: VideoApiService
) {

    private val TAG = "VideoRepository"

    suspend fun getVideosByModuleId(moduleId: Long): Response<List<VideoDTO>> {
        return try {
            val response = videoApiService.getVideosByModuleId(moduleId)
            Log.d(TAG, "getVideosByModuleId: Respuesta del servidor: $response")
            response
        } catch (e: Exception) {
            Log.e(TAG, "getVideosByModuleId: Error al obtener los videos", e)
            throw e
        }
    }
}