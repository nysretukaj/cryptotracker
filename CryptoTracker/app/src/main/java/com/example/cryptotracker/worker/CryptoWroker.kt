package com.example.cryptotracker.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.cryptotracker.R

class CryptoWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        // Kjo pjesë ekzekutohet në prapaskenë
        sendNotification()
        return Result.success()
    }

    private fun sendNotification() {
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "crypto_updates"

        // 1. Krijojmë kanalin (I detyrueshëm për Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Crypto Updates",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }

        // 2. Ndërtojmë njoftimin
        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_sun) // Përdorim ikonën që kemi
            .setContentTitle("CryptoTracker")
            .setContentText("Mos harro të kontrollosh çmimin e Bitcoin sot!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // 3. Shfaqim njoftimin
        manager.notify(1, notification)
    }
}