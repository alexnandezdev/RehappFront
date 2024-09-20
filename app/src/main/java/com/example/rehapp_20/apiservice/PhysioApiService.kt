package com.example.rehapp_20.apiservice

import com.example.rehapp_20.models.AssignPatientDTO
import com.example.rehapp_20.models.PhysioUserRegisterDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PhysioApiService {

    @POST("/rehapp/physiotherapist/register")
    suspend fun registerPhysiotherapist(@Body physioUserRegisterDTO: PhysioUserRegisterDTO): Response<PhysioUserRegisterDTO>

    @POST("/rehapp/physiotherapist/assign-patient")
    suspend fun assignPatientToPhysiotherapist(@Body assignPatientDTO: AssignPatientDTO): Response<String>

}