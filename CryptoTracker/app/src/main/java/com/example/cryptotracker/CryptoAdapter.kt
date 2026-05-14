package com.example.cryptotracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.databinding.ItemCryptoBinding
import coil.load

// Hiq "private val" nga konstruktori dhe bëje listën bosh në fillim
class CryptoAdapter(
    private var cryptoList: List<CryptoModel> = emptyList(),
    private val onItemClick: (CryptoModel) -> Unit
) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    // Funksion për të ndryshuar të dhënat kur vijnë nga interneti
    fun updateData(newList: List<CryptoModel>) {
        cryptoList = newList
        notifyDataSetChanged() // I thotë listës të vizatohet nga e para
    }

    class CryptoViewHolder(val binding: ItemCryptoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptoList[position]

        holder.binding.tvName.text = crypto.name
        holder.binding.tvSymbol.text = crypto.symbol.uppercase()
        holder.binding.tvPrice.text = "$${crypto.currentPrice}"

        // --- PJESA E RE: Ngarkimi i Imazhit ---
        // Përdorim Coil për të ngarkuar url-në (crypto.image)
        holder.binding.ivLogo.load(crypto.image) {
            crossfade(true) // Efekt i butë kur shfaqet
            placeholder(R.drawable.ic_launcher_foreground) // Çfarë të shfaqet sa po ngarkohet
            error(R.drawable.ic_launcher_foreground) // Çfarë të shfaqet nëse dështon
        }
        // --------------------------------------

        holder.itemView.setOnClickListener { onItemClick(crypto) }
    }

    override fun getItemCount(): Int = cryptoList.size
}

private fun CryptoAdapter.placeholder(icLauncherForeground: Int) {}
