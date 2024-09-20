package com.example.rehapp_20.models

import com.example.rehapp_20.enums.UserType

data class PhysioUserRegisterDTO(
    val email: String,
    val userName: String,
    val password: String,
    val userType: UserType,
    val identificationNumber: String,
    val professionalCardNumber: String,
    val phoneNumber: String
)
