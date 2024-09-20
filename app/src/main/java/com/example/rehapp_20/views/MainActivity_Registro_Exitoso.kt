package com.example.rehapp_20.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rehapp_20.R

// La clase MainActivity_Registro_Exitoso extiende AppCompatActivity y representa una actividad que se muestra después de un registro exitoso.
class MainActivity_Registro_Exitoso : AppCompatActivity() {

    // Método que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registro_exitoso) // Establece el diseño de la actividad con el layout correspondiente.

        // Encuentra el botón con el ID 'ButtonAvanzarEncuesta' y lo asigna a la variable 'txt'.
        val txt: Button = findViewById(R.id.ButtonAvanzarEncuesta)

        // Configura un listener para manejar los clics en el botón. Al hacer clic, se navega a la actividad 'MainActivity_Menu_Principal'.
        txt.setOnClickListener {
            val intent: Intent = Intent(this, activity_inicio_paciente::class.java)
            startActivity(intent) // Inicia la actividad 'MainActivity_Menu_Principal'.
        }
    }
}