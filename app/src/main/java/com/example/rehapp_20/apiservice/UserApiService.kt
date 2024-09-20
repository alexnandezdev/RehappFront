package com.example.rehapp_20.apiservice

import com.example.rehapp_20.models.PatientUserRegisterDTO
import com.example.rehapp_20.models.UserDTO
import com.example.rehapp_20.models.UpdatePasswordDTO
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {

    @POST("/rehapp/user/save")
    suspend fun createUser(@Body userRegister: PatientUserRegisterDTO): Response<PatientUserRegisterDTO>

    @GET("/rehapp/user/{id}")
    suspend fun getUserById(@Path("id") id: Long): Response<UserDTO>

    @PUT("/rehapp/user/update")
    suspend fun updateUser(@Body userDto: UserDTO): Response<UserDTO>

    @POST("/rehapp/user/login")
    suspend fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<UserDTO>

    @PUT("/rehapp/user/updatePassword")
    suspend fun updatePassword(@Body updatePasswordDTO: UpdatePasswordDTO): Response<String>

    @GET("/rehapp/user/find-patient")
    suspend fun findPatientByIdentificationNumber(
        @Query("identificationNumber") identificationNumber: String
    ): Response<UserDTO>

}