package com.example.rehapp_20.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rehapp_20.R
import com.google.firebase.auth.FirebaseAuth

// Clase ForgotPassword, que maneja el restablecimiento de contraseña
class ForgotPassword : AppCompatActivity() {

    // Declaración de la instancia de FirebaseAuth para manejar la autenticación
    private lateinit var auth: FirebaseAuth

    // Método que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password) // Asocia el layout XML con la actividad

        // Inicializa Firebase Auth para el manejo de autenticación
        auth = FirebaseAuth.getInstance()

        // Referencias a los elementos de la interfaz (campo de correo y botón de restablecimiento)
        val editTextEmail: EditText = findViewById(R.id.editTextEmailForgotPassword)
        val buttonResetPassword: Button = findViewById(R.id.buttonResetPassword)

        // Establece el listener para el botón de restablecimiento
        buttonResetPassword.setOnClickListener {
            // Obtiene el correo electrónico ingresado por el usuario
            val email = editTextEmail.text.toString().trim()

            // Verifica si el campo de correo no está vacío
            if (email.isNotEmpty()) {
                // Verifica si el correo tiene un formato válido
                if (isValidEmail(email)) {
                    resetPassword(email) // Llama al método para restablecer la contraseña
                } else {
                    // Muestra un mensaje si el formato del correo no es válido
                    Toast.makeText(this, "Por favor, ingresa un correo electrónico válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Muestra un mensaje si el campo de correo está vacío
                Toast.makeText(this, "Por favor, ingresa tu correo electrónico.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método que valida si el correo electrónico tiene el formato correcto
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Método para enviar el correo de restablecimiento de contraseña
    private fun resetPassword(email: String) {
        // Usa FirebaseAuth para enviar el correo de restablecimiento
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                // Verifica si el envío fue exitoso
                if (task.isSuccessful) {
                    Log.d("ForgotPassword", "Correo de restablecimiento enviado.")
                    Toast.makeText(this, "Correo de restablecimiento enviado.", Toast.LENGTH_SHORT).show()
                } else {
                    // Muestra un mensaje si hubo un error al enviar el correo
                    Log.w("ForgotPassword", "Error al enviar el correo: ${task.exception?.message}")
                    Toast.makeText(this, "Error al enviar el correo: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}