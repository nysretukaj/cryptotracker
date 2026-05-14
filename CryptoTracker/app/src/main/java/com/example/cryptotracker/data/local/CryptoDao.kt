package com.example.cryptotracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptotracker.CryptoModel
import kotlinx.coroutines.flow.Flow
@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptos: List<CryptoModel>)

    // Kjo nuk ka 'suspend' sepse Flow eshte stream i vazhdueshem
    @Query("SELECT * FROM crypto_table ORDER BY marketCapRank ASC")
    fun getAllCryptos(): Flow<List<CryptoModel>>

    @Query("DELETE FROM crypto_table")
    suspend fun deleteAll()
}