package com.example.rehapp_20

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class Reproductor11 : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor11)

        // Inicializa el PlayerView y ExoPlayer
        playerView = findViewById(R.id.videoModulo1)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        // Solo se reproducirá este video, que puede estar en la carpeta res/raw
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_1_1) // Cambia "video_local" al nombre real de tu video en res/raw
        val mediaItem = MediaItem.fromUri(videoUri)

        // Configurar y reproducir el video
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    // Pausar el video cuando la actividad no está en primer plano
    override fun onPause() {
        super.onPause()
        player.pause()
    }

    // Reanudar la reproducción del video cuando la actividad vuelve a primer plano
    override fun onResume() {
        super.onResume()
        player.play()
    }

    // Liberar el reproductor al destruir la actividad
    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}