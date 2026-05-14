package com.example.cryptotracker

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs // <--- E RNDESISHME
import com.bumptech.glide.Glide // Nese perdor Glide per fotot
import com.example.cryptotracker.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs() // Merr argumentet
    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        // Vendosim tekstet
        binding.detailName.text = args.cryptoName
        binding.detailSymbol.text = args.cryptoSymbol
        binding.detailPrice.text = "$ ${args.cryptoPrice}"

        // Ngarkojme imazhin me Glide (nese e ke shtuar te build.gradle)
        Glide.with(this)
            .load(args.cryptoImage)
            //.into(binding.detailImage)
    }
}