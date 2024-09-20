package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.views.Calendario
import com.example.rehapp_20.views.MainActivity_Menu_Principal
import com.example.rehapp_20.views.Notificaciones

class vista_fisio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_fisio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val concuesta2: ImageView = findViewById(R.id.nav_profile )
        concuesta2.setOnClickListener {

            val intent: Intent = Intent(this, perfil_paciente :: class.java)
            startActivity(intent)



    }
        val concuesta3: ImageView = findViewById(R.id.nav_calendario )
        concuesta3.setOnClickListener {

            val intent: Intent = Intent(this, Calendario:: class.java)
            startActivity(intent)


        }
        val concuesta4: ImageView = findViewById(R.id.nav_home )
        concuesta4.setOnClickListener {

            val intent: Intent = Intent(this, MainActivity_Menu_Principal :: class.java)
            startActivity(intent)

}
}
}