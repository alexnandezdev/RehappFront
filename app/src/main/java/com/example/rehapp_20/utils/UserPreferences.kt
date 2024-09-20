package com.example.rehapp_20.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.rehapp_20.models.UserDTO
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(@ApplicationContext context: Context){

    private val preferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    private val TAG = "UserPreferences"

    fun saveUser(user: UserDTO) {
        val userJson = Gson().toJson(user)
        preferences.edit().putString("user_data", userJson).apply()
        Log.d(TAG, "saveUser: Usuario guardado -> $userJson")
    }

    fun getUser(): UserDTO? {
        val userJson = preferences.getString("user_data", null)
        return if (userJson != null) {
            val user = Gson().fromJson(userJson, UserDTO::class.java)
            Log.d(TAG, "getUser: Usuario recuperado -> $userJson")
            user
        } else {
            Log.d(TAG, "getUser: No se encontró ningún usuario guardado")
            null
        }
    }

    fun clearUser() {
        preferences.edit().remove("user_data").apply()
        Log.d(TAG, "clearUser: Usuario eliminado de SharedPreferences")
    }

}