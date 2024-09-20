package com.example.rehapp_20


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.rehapp_20.utils.UserPreferences
import com.example.rehapp_20.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditarPerfilPacienteActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_perfil_paciente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Recuperar los datos del usuario desde UserPreferences
        val user = userPreferences.getUser()

        // Cargar datos en los campos de edición
        user?.let {
            findViewById<EditText>(R.id.text_nombre_paciente).setText(it.userName)
            findViewById<EditText>(R.id.text_numero_identificacion).setText(it.identificationNumber)
            findViewById<EditText>(R.id.text_ubicacion_paciente).setText(it.city)
            findViewById<EditText>(R.id.text_telefono_paciente).setText(it.phoneNumber)
            findViewById<EditText>(R.id.text_correo_paciente).setText(it.email)
            findViewById<EditText>(R.id.text_edad).setText(it.age.toString())
        }

        // Configurar el botón de retroceso
        val backButton: ImageView = findViewById(R.id.modulo1)
        backButton.setOnClickListener {
            finish()
        }

        // Configurar el botón de guardar
        val saveButton: Button = findViewById(R.id.ButtonEditarPaciente)
        saveButton.setOnClickListener {
            val updatedUser = user?.copy(
                userName = findViewById<EditText>(R.id.text_nombre_paciente).text.toString(),
                identificationNumber = findViewById<EditText>(R.id.text_numero_identificacion).text.toString(),
                city = findViewById<EditText>(R.id.text_ubicacion_paciente).text.toString(),
                phoneNumber = findViewById<EditText>(R.id.text_telefono_paciente).text.toString(),
                email = findViewById<EditText>(R.id.text_correo_paciente).text.toString(),
                age = findViewById<EditText>(R.id.text_edad).text.toString().toIntOrNull() ?: 0
            )

            if (updatedUser != null) {
                userViewModel.updateUser(updatedUser)

                userViewModel.updateResult.observe(this) { response ->
                    if (response.isSuccessful) {
                        Toast.makeText(this, "Perfil actualizado exitosamente", Toast.LENGTH_SHORT).show()
                        userPreferences.saveUser(updatedUser)
                        finish() // Cierra la actividad después de guardar
                    } else {
                        Toast.makeText(this, "Error al actualizar el perfil", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}


