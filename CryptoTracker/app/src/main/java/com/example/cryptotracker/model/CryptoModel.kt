package com.example.cryptotracker.model

import com.google.gson.annotations.SerializedName

// Kjo klase perfaqeson nje monedhe nga interneti
data class CryptoModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("current_price") val currentPrice: Double,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("high_24h") val high24h: Double,
    @SerializedName("low_24h") val low24h: Double
)