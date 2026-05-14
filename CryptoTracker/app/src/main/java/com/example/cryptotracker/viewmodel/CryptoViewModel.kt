package com.example.cryptotracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.CryptoApplication
import com.example.cryptotracker.CryptoModel
import com.example.cryptotracker.repository.CryptoRepository
import kotlinx.coroutines.launch

class CryptoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CryptoRepository

    // Kjo listë përditësohet automatikisht sa herë ndryshon DB
    val cryptoList: LiveData<List<CryptoModel>>

    init {
        // 1. Inicializojmë Repository
        val cryptoDao = (application as CryptoApplication).database.cryptoDao()
        repository = CryptoRepository(cryptoDao)

        // 2. Lidh Flow me LiveData (kjo e mban listen gjithmon te fresket nga DB)
        cryptoList = repository.allCryptos.asLiveData()

        // 3. Provojmë të marrim të dhëna të reja nga interneti sapo hapet appi
        refreshData()
    }

    // Funksion per te bere refresh manualisht (psh. SwipeRefresh)
    fun refreshData() {
        viewModelScope.launch {
            repository.refreshCryptos()
        }
    }
}