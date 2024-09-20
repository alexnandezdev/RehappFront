package com.example.rehapp_20.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.rehapp_20.R

class activity_bienvenida : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        // Inicializar PlayerView y ExoPlayer
        playerView = findViewById(R.id.videoBienvenida)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.bienv)
        val mediaItem = MediaItem.fromUri(videoUri)
        player.setMediaItem(mediaItem)
        player.prepare()

        // Manejo del botón para iniciar la actividad correspondiente al fisioterapeuta
        val txt: Button = findViewById(R.id.button_fisioterapeuta)
        txt.setOnClickListener {
            val intent = Intent(this, inicio_Fisio::class.java)
            startActivity(intent)
        }
        val txt1: Button = findViewById(R.id.button_paciente)
        txt1.setOnClickListener {
            val intent = Intent(this, activity_inicio_paciente::class.java)
            startActivity(intent)

    }
        // Reproducción automática del video
        player.play()
    }

    // Manejo del ciclo de vida del reproductor para evitar fugas de memoria
    override fun onPause() {
        super.onPause()
        player.pause()
    }

    override fun onResume() {
        super.onResume()
        player.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}