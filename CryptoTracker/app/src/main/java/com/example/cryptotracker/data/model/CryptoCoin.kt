package com.example.cryptotracker.data.model

import android.os.Parcelable // Import i ri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize // Import i ri

@Parcelize // <--- Shto kete
@Entity(tableName = "crypto_table")
data class CryptoCoin(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("current_price")
    val currentPrice: Double,

    @SerializedName("high_24h")
    val high24h: Double?,

    @SerializedName("low_24h")
    val low24h: Double?
) : Parcelable // <--- Shto kete ": Parcelable"