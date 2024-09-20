package com.example.rehapp_20.views

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class Funciones {

    // Función para crear y mostrar una notificación instantánea
    fun NotificacionInstantanea(context: Context, Titulo: String, TextoCorto: String, TextoLargo: String) {

        // Intent para abrir la actividad Calendario cuando se hace clic en la notificación
        val intent = Intent(context, Calendario::class.java).apply {
            // Configura el Intent para que limpie el historial y abra la actividad en una nueva tarea
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // Definición de la flag para el PendingIntent según la versión de Android
        val flag: Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            0
        }

        // PendingIntent para que la notificación abra la actividad Calendario
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, flag)

        // Creación de la notificación usando NotificationCompat.Builder
        val notificacion = NotificationCompat.Builder(context, AlarmaNotificacion.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_menu_my_calendar) // Icono de la notificación
            .setContentTitle(Titulo) // Título de la notificación
            .setContentText(TextoCorto) // Texto corto de la notificación
            .setStyle(NotificationCompat.BigTextStyle().bigText(TextoLargo)) // Estilo expandido con texto largo
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Prioridad de la notificación
            .setContentIntent(pendingIntent) // Acción que se ejecuta al hacer clic en la notificación
            .build() // Construye la notificación

        // Obtención del NotificationManager para enviar la notificación
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Muestra la notificación
        manager.notify(AlarmaNotificacion.NOTIFICATION_ID, notificacion)
    }
}