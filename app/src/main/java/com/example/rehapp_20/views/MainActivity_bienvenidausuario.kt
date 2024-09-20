package com.example.rehapp_20.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rehapp_20.R

// La clase MainActivity_bienvenidausuario hereda de AppCompatActivity, lo que la convierte en una actividad.
class MainActivity_bienvenidausuario : AppCompatActivity() {

    // Método que se ejecuta cuando la actividad se crea.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bienvenidausuario) // Establece el layout para esta actividad usando el archivo XML correspondiente.

        // Encuentra el botón en el layout con el ID 'link_iniciar_sesion'.
        val txt: Button = findViewById(R.id.link_iniciar_sesion)

        // Configura un listener para manejar el evento de clic del botón.
        txt.setOnClickListener {
            // Crea un Intent para iniciar la actividad 'activity_bienvenida'.
            val intent: Intent = Intent(this, activity_bienvenida::class.java)

            // Inicia la actividad 'activity_bienvenida'.
            startActivity(intent)
        }
    }
}