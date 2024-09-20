package com.example.rehapp_20.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.rehapp_20.R
import com.example.rehapp_20.perfil_paciente


// La clase MainActivity_modulo_menu extiende AppCompatActivity, lo que la convierte en una actividad principal de la aplicación.
class MainActivity_modulo_menu : AppCompatActivity() {

    // Método onCreate que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_modulo_menu) // Establece el diseño de la actividad con el layout correspondiente.

        // Encuentra el LinearLayout con el ID 'Liner1' y lo asigna a la variable 'concuesta4'.
        val concuesta4: LinearLayout = findViewById(R.id.Liner1)

        // Configura un listener para manejar los clics en el LinearLayout. Al hacer clic, se navega a la actividad 'modulo1'.
        concuesta4.setOnClickListener {
            val intent: Intent = Intent(this, modulo1::class.java)
            startActivity(intent) // Inicia la actividad 'modulo1'.
        }

        // Encuentra el LinearLayout con el ID 'Liner2' y lo asigna a la variable 'txt'.
        val txt: LinearLayout = findViewById(R.id.Liner2)

        // Listener para el LinearLayout que inicia la actividad 'modulo2'.
        txt.setOnClickListener {
            val intent: Intent = Intent(this, modulo2::class.java)
            startActivity(intent) // Inicia la actividad 'modulo2'.
        }

        // Encuentra el LinearLayout con el ID 'Liner3' y lo asigna a la variable 'Concuenta'.
        val Concuenta: LinearLayout = findViewById(R.id.Liner3)

        // Listener para el LinearLayout que inicia la actividad 'modulo3'.
        Concuenta.setOnClickListener {
            val intent: Intent = Intent(this, modulo3::class.java)
            startActivity(intent) // Inicia la actividad 'modulo3'.
        }

        // Encuentra la ImageView con el ID 'nav_home' y la asigna a la variable 'txt3'.
        val txt3: ImageView = findViewById(R.id.nav_home)

        // Listener para la imagen que inicia la actividad 'MainActivity_Menu_Principal'.
        txt3.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity_Menu_Principal::class.java)
            startActivity(intent) // Inicia la actividad 'MainActivity_Menu_Principal'.
        }

        // Encuentra la ImageView con el ID 'nav_calendario' y la asigna a la variable 'txt4'.
        val txt4: ImageView = findViewById(R.id.nav_calendario)

        // Listener para la imagen que inicia la actividad 'Calendario'.
        txt4.setOnClickListener {
            val intent: Intent = Intent(this, Calendario::class.java)
            startActivity(intent) // Inicia la actividad 'Calendario'.
        }

        // Encuentra la ImageView con el ID 'nav_profile' y la asigna a la variable 'txt5'.
        val txt5: ImageView = findViewById(R.id.nav_profile)

        // Listener para la imagen que inicia la actividad 'perfil_usuario'.
        txt5.setOnClickListener {
            val intent: Intent = Intent(this, perfil_paciente::class.java)
            startActivity(intent) // Inicia la actividad 'perfil_usuario'.
        }

        // Encuentra la ImageView con el ID 'nav_Atras' y la asigna a la variable 'txt6'.
        val txt6: ImageView = findViewById(R.id.nav_Atras)

        // Listener para la imagen que inicia la actividad 'MainActivity_Menu_Principal'.
        txt6.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity_Menu_Principal::class.java)
            startActivity(intent) // Inicia la actividad 'MainActivity_Menu_Principal'.
        }
    }
}
