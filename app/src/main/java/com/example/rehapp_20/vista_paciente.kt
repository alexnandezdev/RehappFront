package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.views.Calendario
import com.example.rehapp_20.views.MainActivity_Menu_Principal

class vista_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_paciente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    // Botón de navegación: home
    findViewById<ImageButton>(R.id.nav_home).setOnClickListener {
        val intent = Intent(this, menu_fisio::class.java)
        startActivity(intent)
    }

    // Botón de navegación: perfil
    findViewById<ImageButton>(R.id.nav_profile).setOnClickListener {
        val intent = Intent(this, perfil_paciente::class.java)
        startActivity(intent)
    }
    }
}