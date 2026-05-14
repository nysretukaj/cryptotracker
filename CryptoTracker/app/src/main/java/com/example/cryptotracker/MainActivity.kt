package com.example.cryptotracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.cryptotracker.worker.CryptoWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Nisim procesin e njoftimeve në prapaskenë
        setupWorker()
    }

    private fun setupWorker() {
        // Krijojmë kërkesën: Puno çdo 15 minuta
        val workRequest = PeriodicWorkRequestBuilder<CryptoWorker>(
            15, TimeUnit.MINUTES
        ).build()

        // E vendosim në radhë me emrin "crypto_work"
        // "KEEP" do të thotë: Nëse puna ekziston tashmë, mos e nis nga e para (që të mos kemi dyfishime)
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "crypto_work",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}