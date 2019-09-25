package com.sorrytale.amazon

import android.app.IntentService
import android.content.Intent
import android.content.Context

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_NOTIFY = "com.sorrytale.amazon.action.NOTIFY"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class Notifier : IntentService("Notifier") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_NOTIFY -> {
                Notifications.createNotificationChannel(this)
                Notifications.sendStaticNotification(
                    this,
                    "Delivered",
                    "Your package has been delivered - check out a photo of your delivery!",
                    100,
                    R.drawable.ic_amazon
                )
            }
        }
        val notification = Notifications.buildStaticNotification(
            this,
            "",
            "",
            R.drawable.ic_amazon
        )
        startForeground(101, notification)
    }
}
