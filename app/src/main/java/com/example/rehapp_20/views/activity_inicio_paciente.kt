package com.example.rehapp_20.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rehapp_20.R
import com.example.rehapp_20.perfil_paciente
import com.example.rehapp_20.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class activity_inicio_paciente : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        // Setup button listener para el login
        val buttonLinkCuenta: Button = findViewById(R.id.ButtonLinkCuenta)
        buttonLinkCuenta.setOnClickListener {
            val email = findViewById<EditText>(R.id.text_Nombre_inicio).text.toString()
            val password = findViewById<EditText>(R.id.tex_Contraseña_inicio).text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, ingresa tu correo y contraseña.", Toast.LENGTH_SHORT).show()
            }
        }

        // Observa el resultado del login
        userViewModel.loginResult.observe(this, Observer { response ->
            if (response.isSuccessful) {
                // Login exitoso, navegar a la pantalla de perfil
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity_Menu_Principal::class.java)
                startActivity(intent)
                finish() // Finaliza esta actividad
            } else {
                // Mostrar error en caso de fallo
                Toast.makeText(this, "Error en el inicio de sesión: ${response.message()}", Toast.LENGTH_SHORT).show()
                Log.e("activity_inicio_sesion", "Error en el inicio de sesión: ${response.errorBody()?.string()}")
            }
        })

        // Setup button listener para el registro de paciente
        val buttonLinkRegistro: Button = findViewById(R.id.ButtonLinkRegistro)
        buttonLinkRegistro.setOnClickListener {
            val intent = Intent(this, activity_registro_usuario::class.java)
            startActivity(intent)
        }

        // Setup text view listener para restablecer contraseña
        val textViewOlvideContraseña: TextView = findViewById(R.id.textViewOlvideContraseña)
        textViewOlvideContraseña.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        Log.d("activity_inicio_sesion", "Iniciando login para el usuario: $email")
        userViewModel.loginUser(email, password)
    }
}
