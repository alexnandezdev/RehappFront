package com.example.rehapp_20.models

import com.example.rehapp_20.enums.UserType

data class PatientUserRegisterDTO(
    val email: String,
    val userName: String,
    val password: String,
    val userType: UserType
)
