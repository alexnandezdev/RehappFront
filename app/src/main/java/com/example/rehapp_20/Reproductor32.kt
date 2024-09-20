package com.example.rehapp_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class Reproductor32 : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor32)

        // Inicialización del PlayerView y el ExoPlayer
        playerView = findViewById(R.id.videoModulo1)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        // Cargar el video desde los recursos internos
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_3_2)
        val mediaItem = MediaItem.fromUri(videoUri)
        player.setMediaItem(mediaItem)
        player.prepare()

        // Reproducción automática
        player.playWhenReady = true
    }

    override fun onPause() {
        super.onPause()
        // Mantener el video en reproducción al pausar la actividad
        player.playWhenReady = false
    }

    override fun onResume() {
        super.onResume()
        // Reanudar la reproducción al reanudar la actividad
        player.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}