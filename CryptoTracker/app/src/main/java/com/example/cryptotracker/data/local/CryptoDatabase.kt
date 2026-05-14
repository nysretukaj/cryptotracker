package com.example.cryptotracker.data.local // <--- EDHE KETU PAKETA NJESOJ

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptotracker.CryptoModel

@Database(entities = [CryptoModel::class], version = 2, exportSchema = false) // Ndryshova versionin ne 2 per siguri
abstract class CryptoDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao

    companion object {
        @Volatile
        private var INSTANCE: CryptoDatabase? = null

        fun getDatabase(context: Context): CryptoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoDatabase::class.java,
                    "crypto_database"
                )
                    .fallbackToDestructiveMigration() // <--- SHTO KETE: Rregullon crash-in nese ndryshon modeli
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}