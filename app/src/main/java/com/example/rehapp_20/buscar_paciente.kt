package com.example.rehapp_20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rehapp_20.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class buscar_paciente : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_paciente)  // Usa el archivo XML

        // Referencia a los elementos del layout
        val textNumeroId: EditText = findViewById(R.id.text_numero_id)
        val buttonBuscarPaciente: Button = findViewById(R.id.buttonBuscarPaciente)
        val resultadosPaciente: TextView = findViewById(R.id.resultadosPaciente)

        // Configuración del botón para buscar paciente
        buttonBuscarPaciente.setOnClickListener {
            val identificationNumber = textNumeroId.text.toString()
            if (identificationNumber.isNotEmpty()) {
                userViewModel.findPatientByIdentificationNumber(identificationNumber)
            } else {
                textNumeroId.error = "Por favor ingrese un número de identificación"
            }
        }

        userViewModel.patientSearchResult.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val patient = response.body()
                if (patient != null) {
                    val userName = patient.userName ?: "Nombre no disponible"
                    val identificationNumber = patient.identificationNumber ?: "Número de identificación no disponible"
                    val age = patient.age?.toString() ?: "Edad no disponible"
                    val sex = patient.sex ?: "Sexo no disponible"
                    val email = patient.email ?: "Email no disponible"
                    val phoneNumber = patient.phoneNumber ?: "Número de teléfono no disponible"
                    val city = patient.city ?: "Ciudad no disponible"
                    val userType = patient.userType?.name ?: "Tipo de usuario no disponible"


                    val resultadoTexto = """
                Nombre: $userName
                ID: $identificationNumber
                Edad: $age
                Sexo: $sex
                Email: $email
                Teléfono: $phoneNumber
                Ciudad: $city
                Tipo de Usuario: $userType
          
            """.trimIndent()

                    resultadosPaciente.text = resultadoTexto
                } else {
                    resultadosPaciente.text = "Paciente no encontrado"
                }
            } else {
                resultadosPaciente.text = "Error al buscar paciente: ${response.errorBody()?.string()}"
            }
        })
}
}