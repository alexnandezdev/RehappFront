package com.example.rehapp_20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rehapp_20.views.MainActivity_Menu_Principal

// Definición de la actividad registro_exitoso_Fisio
class registro_exitoso_Fisio : AppCompatActivity() {

    // Método que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita el diseño que permite que la interfaz se extienda de borde a borde en la pantalla
        enableEdgeToEdge()

        // Establece el layout que se usará para esta actividad
        setContentView(R.layout.activity_registro_exitoso_fisio)

        // Ajusta el padding de la vista principal para que no se superponga con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Obtiene los márgenes del sistema (barras de estado, navegación, etc.)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Aplica el padding de acuerdo con las barras del sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Devuelve los insets aplicados
            insets
        }

        // Asocia el botón con el ID "ButtonAvanzarMenuFisio" al objeto "txt"
        val txt: Button = findViewById(R.id.ButtonAvanzarMenuFisio)

        // Define una acción cuando se haga clic en el botón "Avanzar"
        txt.setOnClickListener {
            // Crea un Intent para iniciar la actividad del menú del fisioterapeuta
            val intent: Intent = Intent(this, menu_fisio::class.java)

            // Inicia la actividad usando el Intent creado
            startActivity(intent)
        }
    }
}
