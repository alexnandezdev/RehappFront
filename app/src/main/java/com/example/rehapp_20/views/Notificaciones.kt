@file:Suppress("DEPRECATION")

package com.example.rehapp_20.views

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.rehapp_20.R
import com.example.rehapp_20.databinding.ActivityNotificacionesBinding

class Notificaciones : AppCompatActivity() {
    private lateinit var binding: ActivityNotificacionesBinding

    private lateinit var notificacion1: LinearLayout
    private lateinit var notificacion2: LinearLayout

//    private val citaReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            if (intent?.action == "NUEVA_CITA_CREADA") {
//                actualizarNotificaciones(intent)
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)

        binding = ActivityNotificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let { extras ->
            val modulo = extras.getString("modulo", "")
            val fisioterapeuta = extras.getString("fisioterapeuta", "")
            val fecha = extras.getString("fecha", "")
            val hora = extras.getString("hora", "")


            binding.tvNotificacion1Modulo.text = "Modulo: $modulo"
            binding.tvNotificacion1Fisio.text = "Fisioterapeuta: $fisioterapeuta"
            binding.tvNotificacion1Fecha.text = "Fecha: $fecha"
            binding.tvNotificacion1Hora.text = "Hora: $hora"


        }

        notificacion1 = findViewById(R.id.notificacion1)
        notificacion2 = findViewById(R.id.notificacion2)

        setupNavigationButtons()
        setupFilterButtons()

        // Registrar el BroadcastReceiver
        //LocalBroadcastManager.getInstance(this).registerReceiver(
        //citaReceiver,
        // IntentFilter("NUEVA_CITA_CREADA")
        //)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        // Desregistrar el BroadcastReceiver
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(citaReceiver)
//    }

    private fun setupNavigationButtons() {
        // ... (sin cambios) ...
    }

    private fun setupFilterButtons() {
        val btnRecientes = findViewById<ImageButton>(R.id.imageButton_recientes)
        val btnArchivados = findViewById<ImageButton>(R.id.imageButton_archivados)
        val btnBorrarTodo = findViewById<ImageButton>(R.id.imageButton_borrartodo)

        btnRecientes.setOnClickListener { mostrarNotificacionesRecientes() }
        btnArchivados.setOnClickListener { mostrarNotificacionesArchivadas() }
        btnBorrarTodo.setOnClickListener { borrarTodasLasNotificaciones() }
    }
    private fun mostrarNotificacionesRecientes() {
        notificacion1.visibility = View.VISIBLE
        notificacion2.visibility = View.VISIBLE
        Toast.makeText(this, "Mostrando notificaciones recientes", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarNotificacionesArchivadas() {
        notificacion1.visibility = View.GONE
        notificacion2.visibility = View.GONE
        Toast.makeText(this, "Mostrando notificaciones archivadas", Toast.LENGTH_SHORT).show()
    }

    private fun borrarTodasLasNotificaciones() {
        notificacion1.visibility = View.GONE
        notificacion2.visibility = View.GONE
        Toast.makeText(this, "Todas las notificaciones han sido borradas", Toast.LENGTH_SHORT).show()
    }

//    private fun actualizarNotificaciones(intent: Intent) {
//        val modulo = intent.getStringExtra("MODULO") ?: ""
//        val fisio = intent.getStringExtra("FISIOTERAPEUTA") ?: ""
//        val fecha = intent.getStringExtra("FECHA") ?: ""
//        val hora = intent.getStringExtra("HORA") ?: ""
//
//        // Actualizar notificacion1
//        notificacion1.findViewById<TextView>(R.id.tv_notificacion1_modulo).text = modulo
//        notificacion1.findViewById<TextView>(R.id.tv_notificacion1_fisio).text = fisio
//        notificacion1.findViewById<TextView>(R.id.tv_notificacion1_fecha).text = fecha
//        notificacion1.findViewById<TextView>(R.id.tv_notificacion1_hora).text = hora
//
//        notificacion1.visibility = View.VISIBLE
//
//        // Aquí podrías implementar lógica para mover notificaciones antiguas a notificacion2
//        // o para manejar múltiples notificaciones
//    }


}