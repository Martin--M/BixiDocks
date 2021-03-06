package com.martinm.sharedocks

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.text.Html
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHandler {
    private val mApi = ShareApiHandler

    private const val CHANNEL_ID_UPDATES: String = "DocksUpdates"
    private const val CHANNEL_ID_TRACKING: String = "DocksTracking"

    private const val NOTIFICATION_ID_UPDATES = 100001
    const val NOTIFICATION_ID_TRACKING = 100002

    fun initialize(context: Context, notificationManager: NotificationManager) {
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
        notificationManager.createNotificationChannel(chanUpdates)
        notificationManager.createNotificationChannel(chanTracking)
    }

    fun showNotification(
        context: Context,
        title: String,
        message: String,
        details: String? = null
    ) {
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            Intent(context, MapsActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_UPDATES)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)

        if (details != null) {
            builder.setStyle(NotificationCompat.BigTextStyle().bigText(Html.fromHtml(details, 0)))
        }

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID_UPDATES, builder.build())
        }
    }

    fun buildTrackingNotificationMessage(unavailableIds: MutableList<String>): String {
        if (unavailableIds.isEmpty()) {
            return ""
        }
        val builder = StringBuilder()
        unavailableIds.forEach {
            if (mApi.docks[it] != null) {
                builder.append(mApi.docks[it]!!.name)
                    .append("<br>")
            }
        }
        return builder.toString()
    }

    fun removeTrackingNotifications(notificationManager: NotificationManager) {
        notificationManager.cancel(NOTIFICATION_ID_UPDATES)
    }

    fun getForegroundNotification(context: Context): Notification {
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            Utils.RECEIVER_REQUEST_ID_STOP_TRACKING,
            Intent(context, StopTrackingReceiver::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
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