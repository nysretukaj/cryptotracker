package com.example.cryptotracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "crypto_table")
data class CryptoModel(
    @PrimaryKey
    val id: String,

    val symbol: String,
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("current_price")
    val currentPrice: Double,

    // KJO MUNGONTE DHE PO SHKAKTON ERRORIN:
    @SerializedName("market_cap_rank")
    val marketCapRank: Int
)