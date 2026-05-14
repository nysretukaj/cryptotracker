package com.example.cryptotracker.data.remote

import com.example.cryptotracker.data.model.CryptoCoin
import com.example.cryptotracker.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // Ne po marrim listën e marketit
    @GET(Constants.ENDPOINT_MARKETS)
    suspend fun getCoins(
        @Query("vs_currency") currency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): Response<List<CryptoCoin>>
}