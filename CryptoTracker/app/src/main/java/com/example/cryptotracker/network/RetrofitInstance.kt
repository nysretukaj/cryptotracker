package com.example.cryptotracker.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.cryptotracker.network.CryptoApi
object RetrofitInstance {

    private const val BASE_URL = "https://api.coingecko.com/api/v3/"

    val api: CryptoApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }
}