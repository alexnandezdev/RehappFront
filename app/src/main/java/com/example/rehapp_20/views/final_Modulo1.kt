package com.example.rehapp_20.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rehapp_20.R

class final_Modulo1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_modulo1) // Establece el diseño de la actividad

        // Encuentra el botón con el ID buttonNuevoModulo en el diseño
        val txt: Button = findViewById(R.id.buttonNuevoModulo)

        // Configura el listener del botón para manejar clics
        txt.setOnClickListener {
            // Crea un Intent para iniciar la actividad MainActivity_modulo_menu
            val intent: Intent = Intent(this, MainActivity_modulo_menu::class.java)
            startActivity(intent) // Inicia la nueva actividad
        }
    }
}