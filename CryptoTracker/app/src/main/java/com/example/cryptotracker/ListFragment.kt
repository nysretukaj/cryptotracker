package com.example.cryptotracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptotracker.data.SettingsManager
import com.example.cryptotracker.databinding.FragmentListBinding
import com.example.cryptotracker.viewmodel.CryptoViewModel
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CryptoViewModel by viewModels()
    private lateinit var adapter: CryptoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inicializojmë listën (RecyclerView)
        setupRecyclerView()

        // 2. Inicializojmë menaxherin e preferencave
        val settingsManager = SettingsManager(requireContext())

        // 3. Vëzhgojmë: A duhet të jetë Dark Mode?
        viewLifecycleOwner.lifecycleScope.launch {
            settingsManager.isDarkMode.collect { isDark ->
                if (isDark) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    // Përdorim ikona standarde për të shmangur errorin nëse mungojnë ikonat tuaja
                    binding.btnTheme.setImageResource(android.R.drawable.btn_star_big_on)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    binding.btnTheme.setImageResource(android.R.drawable.btn_star_big_off)
                }
            }
        }

        // 4. Klikimi i butonit për të ndërruar temën
        binding.btnTheme.setOnClickListener {
            // Marrim modin aktual nga sistemi
            val currentMode = AppCompatDelegate.getDefaultNightMode()
            val isCurrentlyDark = currentMode == AppCompatDelegate.MODE_NIGHT_YES

            viewLifecycleOwner.lifecycleScope.launch {
                settingsManager.setDarkMode(!isCurrentlyDark)
            }
        }

        // 5. Vëzhgojmë të dhënat nga ViewModel
        viewModel.cryptoList.observe(viewLifecycleOwner) { list ->
            // Sigurohemi që lista nuk është null
            if (!list.isNullOrEmpty()) {
                adapter.updateData(list)
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = CryptoAdapter { selectedCrypto ->
            // Navigimi drejt Detajeve
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(
                cryptoName = selectedCrypto.name,
                cryptoSymbol = selectedCrypto.symbol,
                cryptoPrice = selectedCrypto.currentPrice.toString(),
                cryptoImage = selectedCrypto.image
            )
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ListFragment.adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}