package com.example.cryptotracker.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.cryptotracker.R

class CryptoPriceService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null // Nuk na duhet binding për këtë rast
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Kur starton shërbimi, dërgo njoftimin
        showNotification()
        return START_STICKY
    }

    private fun showNotification() {
        val channelId = "crypto_price_channel"
        val channelName = "Crypto Alerts"

        // 1. Krijo Kanalin e Njoftimeve (Për Android 8+)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // 2. Ndërto Njoftimin
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Crypto Tracker")
            .setContentText("Po ndjekim çmimet e tregut për ty!")
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Sigurohu që ke një ikonë këtu
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // 3. Shfaq Njoftimin
        notificationManager.notify(1, notification)
    }
}