package com.example.rehapp_20.di

import com.example.rehapp_20.apiservice.ModuleApiService
import com.example.rehapp_20.apiservice.ModuleAssignmentApiService
import com.example.rehapp_20.apiservice.PhysioApiService
import com.example.rehapp_20.apiservice.UserApiService
import com.example.rehapp_20.apiservice.VideoApiService
import com.example.rehapp_20.connection.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserApiService(): UserApiService {
        return RetrofitClient.userApiService
    }

    @Provides
    @Singleton
    fun providePhysioApiService(): PhysioApiService {
        return RetrofitClient.physioApiService
    }

    @Provides
    @Singleton
    fun provideModuleApiService(): ModuleApiService {
        return RetrofitClient.moduleApiService
    }

    @Provides
    @Singleton
    fun provideModuleAssignmentApiService(): ModuleAssignmentApiService {
        return RetrofitClient.moduleAssignmentApiService
    }

    @Provides
    @Singleton
    fun provideVideoApiService(): VideoApiService {
        return RetrofitClient.videoApiService
    }

}