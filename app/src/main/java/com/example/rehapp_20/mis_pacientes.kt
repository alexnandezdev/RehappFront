package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class mis_pacientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mis_pacientes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


    }
    val concuesta4: ImageView = findViewById(R.id.flecha_avanzar_perfil_paciente1)
    concuesta4.setOnClickListener {

        val intent: Intent = Intent(this, vista_paciente :: class.java)
        startActivity(intent)
    }
        val concuesta2: ImageView = findViewById(R.id.image_center )
        concuesta2.setOnClickListener {

            val intent: Intent = Intent(this, buscar_paciente :: class.java)
            startActivity(intent)


        }
}
}

