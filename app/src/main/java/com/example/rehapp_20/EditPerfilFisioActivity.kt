package com.example.rehapp_20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.utils.UserPreferences
import com.example.rehapp_20.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditPerfilFisioActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_perfil_fisio)

        // Ajustar el layout para los insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar los datos del usuario desde UserPreferences
        val user = userPreferences.getUser()

        // Inicializar los campos de texto
        val nombreFisioEditText = findViewById<EditText>(R.id.text_nombre_fisio)
        val identificacionEditText = findViewById<EditText>(R.id.text_numero_identificacion)
        val tarjetaFisioEditText = findViewById<EditText>(R.id.text_targeta_fisio)
        val telefonoFisioEditText = findViewById<EditText>(R.id.text_telefono_fisio)
        val correoFisioEditText = findViewById<EditText>(R.id.text_correo_fisio)
        val edadFisioEditText = findViewById<EditText>(R.id.text_edad_fisio)
        val ubicacionFisioEditText = findViewById<EditText>(R.id.text_ubicacion_fisio)

        // Mostrar los datos actuales en los campos de texto
        user?.let {
            nombreFisioEditText.setText(it.userName)
            identificacionEditText.setText(it.identificationNumber)
            tarjetaFisioEditText.setText(it.professionalCardNumber)
            telefonoFisioEditText.setText(it.phoneNumber)
            correoFisioEditText.setText(it.email)
            edadFisioEditText.setText(it.age.toString())
            ubicacionFisioEditText.setText(it.city)
        }

        // Configurar el botón de guardar
        val guardarButton = findViewById<Button>(R.id.ButtonEditarPaciente)
        guardarButton.setOnClickListener {
            // Recoger los datos actualizados de los campos de texto
            val updatedUser = user?.copy(
                userName = nombreFisioEditText.text.toString(),
                identificationNumber = identificacionEditText.text.toString(),
                professionalCardNumber = tarjetaFisioEditText.text.toString(),
                phoneNumber = telefonoFisioEditText.text.toString(),
                email = correoFisioEditText.text.toString(),
                age = edadFisioEditText.text.toString().toIntOrNull() ?: 0,
                city = ubicacionFisioEditText.text.toString()
            )

            // Llamar al método de actualización en UserViewModel
            updatedUser?.let {
                userViewModel.updateUser(it)
            }
        }

        // Observar los resultados de la actualización
        userViewModel.updateResult.observe(this) { response ->
            if (response.isSuccessful) {
                Toast.makeText(this, "Perfil actualizado exitosamente", Toast.LENGTH_SHORT).show()
                // Actualizar los datos en UserPreferences
                response.body()?.let { updatedUser ->
                    userPreferences.saveUser(updatedUser)
                }
                finish() // Cerrar la actividad después de guardar
            } else {
                Toast.makeText(this, "Error al actualizar el perfil: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el listener para el botón de retroceso
        val retrocederButton: ImageView = findViewById(R.id.modulo1)
        retrocederButton.setOnClickListener {
            finish() // Cerrar la actividad y volver a la vista anterior
        }
    }
}

