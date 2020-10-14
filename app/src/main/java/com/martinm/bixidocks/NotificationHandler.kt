package com.martinm.bixidocks

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHandler {
    private lateinit var mNotificationManager: NotificationManager

    private const val CHANNEL_ID_UPDATES: String = "DocksUpdates"
    private const val CHANNEL_ID_TRACKING: String = "DocksTracking"

    private const val NOTIFICATION_ID_UPDATES = 100001
    const val NOTIFICATION_ID_TRACKING = 100002

    fun initialize(context: Context, notificationManager: NotificationManager) {
        mNotificationManager = notificationManager
        val chanUpdates = NotificationChannel(
            CHANNEL_ID_UPDATES,
            context.getString(R.string.notification_channel_update_name),
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = context.getString(R.string.notification_channel_update_description)
        }
        val chanTracking = NotificationChannel(
            CHANNEL_ID_TRACKING,
            context.getString(R.string.notification_channel_tracking_name),
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = context.getString(R.string.notification_channel_tracking_description)
        }
        mNotificationManager.createNotificationChannel(chanUpdates)
        mNotificationManager.createNotificationChannel(chanTracking)
    }

    fun showNotification(context: Context, message: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_UPDATES)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentTitle(context.getString(R.string.notification_update_title))
            .setContentText(message)

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID_UPDATES, builder.build())
        }
    }

    fun getForegroundNotification(context: Context): Notification {
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            LogicHandler.RECEIVER_REQUEST_ID_STOP_TRACKING,
            Intent(context, StopTrackingReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(context, CHANNEL_ID_TRACKING)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .addAction(
                R.drawable.ic_launcher_foreground,
                context.getString(R.string.notification_tracking_stop_button),
                pendingIntent
            )
            .setContentTitle(context.getString(R.string.notification_tracking_title))
            .build()
    }
}