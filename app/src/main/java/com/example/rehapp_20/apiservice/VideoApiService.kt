package com.example.rehapp_20.apiservice

import com.example.rehapp_20.models.VideoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoApiService {

    @GET("/rehapp/videos/module/{moduleId}")
    suspend fun getVideosByModuleId(@Path("moduleId") moduleId: Long): Response<List<VideoDTO>>

}