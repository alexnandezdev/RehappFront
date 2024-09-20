package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.views.Calendario
import com.example.rehapp_20.views.Notificaciones

class menu_fisio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_fisio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val concuesta4: ImageView = findViewById(R.id.imagen_modulo4)
        concuesta4.setOnClickListener {

            val intent: Intent = Intent(this, perfil_fisio :: class.java)
            startActivity(intent)
        }
            val concuesta1: ImageView = findViewById(R.id.imagen_modulo1)
            concuesta1.setOnClickListener {

                val intent: Intent = Intent(this, mis_pacientes :: class.java)
                startActivity(intent)

            }
        val concuesta2: ImageView = findViewById(R.id.imagen_modulo2)
        concuesta2.setOnClickListener {

            val intent: Intent = Intent(this, Notificaciones_fisio :: class.java)
            startActivity(intent)

    }

}
}
