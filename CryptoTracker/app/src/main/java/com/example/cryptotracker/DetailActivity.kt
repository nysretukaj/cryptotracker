package com.example.cryptotracker

import android.content.Intent // <--- Ky rresht rregullon errorin e Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptotracker.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    // Krijojme variablin per ViewBinding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktivizojme ViewBinding
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Marrim te dhenat qe erdhen nga MainActivity
        val name = intent.getStringExtra("CRYPTO_NAME") ?: "N/A"
        val symbol = intent.getStringExtra("CRYPTO_SYMBOL") ?: "N/A"
        val price = intent.getStringExtra("CRYPTO_PRICE") ?: "0.0"

        // 2. I vendosim te dhenat ne ekran (Rregullon errorin tvDetailSymbol)
        // Sigurohu qe keto ID ekzistojne ne activity_detail.xml
        binding.tvDetailName.text = name
        binding.tvDetailSymbol.text = symbol
        binding.tvDetailPrice.text = price

        // 3. Logjika e butonit Share (Rregullon errorin btnShare, Intent, action)
        binding.btnShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Shiko cmimin e $name ($symbol): $price ne CryptoTracker!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Ndaj me miqtë"))
        }
    }
}