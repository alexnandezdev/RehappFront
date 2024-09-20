package com.example.rehapp_20.connection

import com.example.rehapp_20.apiservice.ModuleApiService
import com.example.rehapp_20.apiservice.ModuleAssignmentApiService
import com.example.rehapp_20.apiservice.PhysioApiService
import com.example.rehapp_20.apiservice.UserApiService
import com.example.rehapp_20.apiservice.VideoApiService
import com.example.rehapp_20.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = Constants.BASE_URL

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }

    val physioApiService: PhysioApiService by lazy {
        retrofit.create(PhysioApiService::class.java)
    }

    val moduleAssignmentApiService: ModuleAssignmentApiService by lazy {
        retrofit.create(ModuleAssignmentApiService::class.java)
    }

    val moduleApiService: ModuleApiService by lazy {
        retrofit.create(ModuleApiService::class.java)
    }

    val videoApiService: VideoApiService by lazy {
        retrofit.create(VideoApiService::class.java)
    }

}