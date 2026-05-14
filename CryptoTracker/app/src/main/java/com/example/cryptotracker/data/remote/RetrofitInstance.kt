package com.example.cryptotracker.data.remote

import com.example.cryptotracker.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // Krijon objektin Retrofit vetëm një herë (Lazy initialization)
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Krijon lidhjen konkrete me API-në
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}