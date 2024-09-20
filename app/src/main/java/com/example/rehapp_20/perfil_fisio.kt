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
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class perfil_fisio : AppCompatActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil_fisio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar los datos del usuario desde UserPreferences
        val user = userPreferences.getUser()

        // Actualizar la vista con los datos del usuario
        user?.let {
            findViewById<TextView>(R.id.textnombre_fisio).text = it.userName
            findViewById<TextView>(R.id.textcorreo_fisio).text = it.email
            findViewById<TextView>(R.id.edit_text_nombre_fisio).setText(it.userName)
            findViewById<TextView>(R.id.edit_text_numero_identificacion).setText(it.identificationNumber)
            findViewById<TextView>(R.id.edit_text_ubicacion_fisio).setText(it.city)
            findViewById<TextView>(R.id.edit_text_contacto).setText(it.phoneNumber)
            findViewById<TextView>(R.id.edit_text_correo_fisio).setText(it.email)
            findViewById<TextView>(R.id.edit_text_edad_fisio).setText(it.age.toString())
            findViewById<TextView>(R.id.edit_text_tarjeta).setText(it.professionalCardNumber)
        }

        // Configurar los listeners para "Salir" y "Editar"
        findViewById<TextView>(R.id.text_Salir).setOnClickListener {
            val intent = Intent(this, menu_fisio::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.text_editar).setOnClickListener {
            val intent = Intent(this, EditPerfilFisioActivity::class.java)
            startActivity(intent)
        }
    }
}
