package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.utils.UserPreferences
import com.example.rehapp_20.views.MainActivity_Menu_Principal
import com.example.rehapp_20.views.activity_inicio_paciente
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class perfil_paciente : AppCompatActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil_paciente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar los datos del usuario desde UserPreferences
        val user = userPreferences.getUser()

        // Actualizar la vista con los datos del usuario
        user?.let {
            findViewById<TextView>(R.id.textnombre_paciente).text = it.userName
            findViewById<TextView>(R.id.textcorreo_paciente).text = it.email
            findViewById<TextView>(R.id.edit_text_nombre_paciente).setText(it.userName)
            findViewById<TextView>(R.id.edit_text_identificacion_paciente).setText(it.identificationNumber)
            findViewById<TextView>(R.id.edit_text_ubicacion_paciente).setText(it.city)
            findViewById<TextView>(R.id.edit_text_contacto_paciente).setText(it.phoneNumber)
            findViewById<TextView>(R.id.edit_text_Correo_paciente).setText(it.email)
            findViewById<TextView>(R.id.edit_text_edad_paciente).setText(it.age.toString())
        }

        // Configurar los listeners para "Salir" y "Editar"
        findViewById<TextView>(R.id.text_Salir).setOnClickListener {
            val intent = Intent(this, activity_inicio_paciente ::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.text_editar).setOnClickListener {
            val intent = Intent(this, EditarPerfilPacienteActivity::class.java)
            startActivity(intent)
        }
    }
}