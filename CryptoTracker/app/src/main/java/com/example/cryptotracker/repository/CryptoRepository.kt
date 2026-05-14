package com.example.cryptotracker.repository

import com.example.cryptotracker.CryptoModel
import com.example.cryptotracker.data.local.CryptoDao
import com.example.cryptotracker.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CryptoRepository(private val cryptoDao: CryptoDao) {

    // 1. Kjo vetem lexon nga DB (Update automatik)
    val allCryptos: Flow<List<CryptoModel>> = cryptoDao.getAllCryptos()

    // 2. Kjo merr te dhenat nga interneti dhe i ruan ne DB
    suspend fun refreshCryptos() = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getCryptos()
            if (response.isSuccessful && response.body() != null) {
                cryptoDao.insertAll(response.body()!!)
            }
        } catch (e: Exception) {
            // Errori injorohet ketu, sepse useri sheh te dhenat e vjetra nga DB
            e.printStackTrace()
        }
    }
}