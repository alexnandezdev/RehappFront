package com.example.rehapp_20.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.rehapp_20.R
import com.example.rehapp_20.perfil_paciente
import com.example.rehapp_20.vista_fisio
import android.net.Uri

// La clase MainActivity_Menu_Principal extiende AppCompatActivity, lo que la convierte en una actividad principal de la aplicación.
class MainActivity_Menu_Principal : AppCompatActivity() {

    // Método onCreate que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_principal) // Establece el diseño de la actividad con el layout correspondiente.

        // Encuentra la ImageView con el ID 'imagen_modulo1' y la asigna a la variable 'concuesta4'.
        val concuesta4: ImageView = findViewById(R.id.imagen_modulo1)

        // Configura un listener para manejar los clics en la imagen. Al hacer clic, se navega a la actividad 'inicio_Fisio'.
        concuesta4.setOnClickListener {
            val intent: Intent = Intent(this, vista_fisio::class.java)
            startActivity(intent) // Inicia la actividad 'inicio_Fisio'.
        }

        // Encuentra la ImageView con el ID 'imagen_modulo2' y la asigna a la variable 'txt'.
        val txt: ImageView = findViewById(R.id.imagen_modulo2)

        // Listener para la imagen que inicia la actividad 'MainActivity_modulo_menu'.
        txt.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity_modulo_menu::class.java)
            startActivity(intent) // Inicia la actividad 'MainActivity_modulo_menu'.
        }

        // Encuentra la ImageView con el ID 'imagen_modulo4' y la asigna a la variable 'Concuenta'.
        val Concuenta: ImageView = findViewById(R.id.imagen_modulo4)

        // Listener para la imagen que inicia la actividad 'perfil_paciente'.
        Concuenta.setOnClickListener {
            val intent: Intent = Intent(this, perfil_paciente::class.java)
            startActivity(intent) // Inicia la actividad 'perfil_paciente'.
        }

        // Encuentra la ImageView con el ID 'imagen_modulo3' y la asigna a la variable 'Concuenta1'.
        val Concuenta1: ImageView = findViewById(R.id.imagen_modulo3)

        // Listener para la imagen que inicia la actividad 'Calendario'.
        Concuenta1.setOnClickListener {
            val intent: Intent = Intent(this, Calendario::class.java)
            startActivity(intent) // Inicia la actividad 'Calendario'.
        }

        // Encuentra la ImageView con el ID 'imagen_modulo5' y la asigna a la variable 'Concuenta2'.
        val Concuenta2: ImageView = findViewById(R.id.imagen_modulo5)

        // Listener para la imagen que inicia la actividad 'Notificaciones'.
        Concuenta2.setOnClickListener {
            val intent: Intent = Intent(this, Notificaciones::class.java)
            startActivity(intent) // Inicia la actividad 'Notificaciones'.
        }

        val imagenModulo6 = findViewById<ImageView>(R.id.imagen_modulo6)

        // Añadir un listener para hacer clic en la imagen
        imagenModulo6.setOnClickListener {
            val url = "https://www.tusitioweb.com" // Cambia la URL por la que desees
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)



    }
}
}