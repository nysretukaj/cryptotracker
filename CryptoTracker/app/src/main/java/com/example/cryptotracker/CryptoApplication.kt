package com.example.cryptotracker

import android.app.Application
import com.example.cryptotracker.data.local.CryptoDatabase // <--- IMPORTI I RI

class CryptoApplication : Application() {
    val database by lazy { CryptoDatabase.getDatabase(this) }
}