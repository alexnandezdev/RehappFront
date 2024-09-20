package com.example.rehapp_20.models

import com.example.rehapp_20.enums.UserType

data class UserDTO(
    val userId: Long,
    val userName: String?,
    val password: String?,
    val identificationNumber: String?,
    val age: Int?,
    val sex: String?,
    val email: String?,
    val phoneNumber: String?,
    val city: String?,
    val userType: UserType?,
    val professionalCardNumber: String?
)
