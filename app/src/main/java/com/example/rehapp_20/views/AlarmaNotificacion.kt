package com.example.rehapp_20.views

import android.app.NotificationManager  // Permite gestionar las notificaciones
import android.app.PendingIntent  // Intención que se ejecutará en el futuro
import android.content.BroadcastReceiver  // Clase base para manejar eventos de broadcast
import android.content.Context  // Proporciona información global sobre el estado de la app
import android.content.Intent  // Utilizado para manejar Intents
import android.os.Build  // Proporciona información sobre la versión del sistema operativo
import androidx.core.app.NotificationCompat  // Compatibilidad con notificaciones

// Esta clase extiende BroadcastReceiver, lo que permite recibir eventos broadcast (ej: alarmas)
class AlarmaNotificacion: BroadcastReceiver() {

    // Variables que contendrán los valores de la notificación (título, texto corto y largo)
    lateinit var Titulo: String
    lateinit var TextoCorto: String
    lateinit var TextoLargo: String

    // Método que se ejecuta cuando se recibe el broadcast (cuando la alarma se dispara)
    override fun onReceive(context: Context, intent: Intent) {
        // Se extraen los valores del intent que lanzó la alarma
        Titulo = intent.getStringExtra("Titulo").toString()
        TextoCorto = intent.getStringExtra("TextoCorto").toString()
        TextoLargo = intent.getStringExtra("TextoLargo").toString()

        // Se programa la notificación
        programarNotificacion(context)
    }

    companion object {
        // Constantes para el ID de la notificación y el canal de notificación
        const val NOTIFICATION_ID = 1  // ID único de la notificación
        const val CHANNEL_ID = "EJEMPLO"  // ID del canal para versiones de Android 8.0 y superiores
    }

    // Función que programa y muestra la notificación
    public fun programarNotificacion(context: Context) {

        // Creación de un Intent para abrir la actividad "Calendario" cuando se haga clic en la notificación
        val intent = Intent(context, Calendario::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK  // Flags para controlar cómo se abre la actividad
        }

        // Establece la forma en que el PendingIntent se comportará según la versión de Android
        val flag: Int
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flag = PendingIntent.FLAG_IMMUTABLE  // Para versiones de Android 6.0 o superior
        } else {
            flag = 0  // Para versiones anteriores
        }

        // Creación del PendingIntent que se ejecutará cuando el usuario toque la notificación
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, flag)

        // Construcción de la notificación
        var notificacion = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_menu_my_calendar)  // Icono pequeño que se muestra en la notificación
            .setContentTitle(Titulo)  // Título de la notificación
            .setContentText(TextoCorto)  // Texto breve de la notificación
            .setStyle(NotificationCompat.BigTextStyle().bigText(TextoLargo))  // Estilo que expande el texto
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)  // Prioridad de la notificación
            .setContentIntent(pendingIntent)  // Acción que se realiza al hacer clic en la notificación
            .build()

        // Gestión de la notificación utilizando NotificationManager
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Muestra la notificación utilizando el ID previamente definido
        manager.notify(NOTIFICATION_ID, notificacion)
    }
}