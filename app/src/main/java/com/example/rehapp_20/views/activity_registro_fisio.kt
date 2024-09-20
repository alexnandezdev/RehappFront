package com.example.rehapp_20.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rehapp_20.R
import com.example.rehapp_20.enums.UserType
import com.example.rehapp_20.menu_fisio
import com.example.rehapp_20.models.PhysioUserRegisterDTO
import com.example.rehapp_20.perfil_fisio
import com.example.rehapp_20.registro_exitoso_Fisio
import com.example.rehapp_20.viewmodels.PhysioViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class activity_registro_fisio : AppCompatActivity() {

    private val physioViewModel: PhysioViewModel by viewModels()
    private val TAG = "activity_registro_fisio"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_fisio)

        val buttonRegistrarme: Button = findViewById(R.id.ButtonRegistrarFisioterapeuta)
        buttonRegistrarme.setOnClickListener {
            val email = findViewById<EditText>(R.id.tex_Correo_fisio).text.toString()
            val password = findViewById<EditText>(R.id.text_contraseña_fisio).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.tex_comfirmar_contraseña_fisio).text.toString()
            val userName = findViewById<EditText>(R.id.text_Nombre_fisio).text.toString()
            val identificationNumber = findViewById<EditText>(R.id.text_identificacion_fisio).text.toString()
            val professionalCardNumber = findViewById<EditText>(R.id.tex_tajeta_fisio).text.toString()
            val phoneNumber = findViewById<EditText>(R.id.text_telefono_fisio).text.toString()

            Log.d(TAG, "onCreate: Click en 'Registrarme' con email: $email")

            if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword && identificationNumber.isNotEmpty() && professionalCardNumber.isNotEmpty() && phoneNumber.isNotEmpty()) {
                val user = PhysioUserRegisterDTO(
                    email = email,
                    userName = userName,
                    password = password,
                    userType = UserType.PHYSIOTHERAPIST,
                    identificationNumber = identificationNumber,
                    professionalCardNumber = professionalCardNumber,
                    phoneNumber = phoneNumber
                )
                Log.d(TAG, "onCreate: Enviando DTO para registro: $user")
                physioViewModel.registerPhysio(user)
            } else {
                Log.w(TAG, "onCreate: Fallo en la validación del formulario")
                Toast.makeText(this, "Por favor, verifica los campos y asegúrate de que las contraseñas coincidan.", Toast.LENGTH_SHORT).show()
            }
        }

        physioViewModel.registrationResult.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d(TAG, "onCreate: Registro exitoso con respuesta: ${response.body()}")
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, registro_exitoso_Fisio ::class.java)
                startActivity(intent)
            } else {
                Log.e(TAG, "onCreate: Fallo en el registro con código: ${response.code()}, mensaje: ${response.message()}")
                Toast.makeText(this, "Fallo en el registro: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
