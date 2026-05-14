# Crypto Tracker Pro 🚀

Crypto Tracker Pro is a modern Android application designed to track real-time cryptocurrency prices. Built with **Kotlin** and following modern Android development practices (**MVVM Architecture**), it ensures a smooth user experience, offline support, and background updates.

## 📱 Features

* **Real-time Data:** Fetches the latest cryptocurrency prices from the CoinGecko API.
* **Offline Support:** Uses **Room Database** to cache data, allowing the app to work even without an internet connection.
* **Detailed View:** View specific details for each cryptocurrency (Image, Name, Symbol, Price).
* **Dark/Light Mode:** Persists user theme preference using **Jetpack DataStore**.
* **Background Updates:** Periodically checks for updates in the background using **WorkManager** and sends notifications.
* **Modern UI:** Clean interface built with ConstraintLayout and Material Design components.

## 🛠 Tech Stack & Libraries

* **Language:** Kotlin 100%
* **Architecture:** MVVM (Model-View-ViewModel)
* **Networking:** Retrofit 2 & Gson Converter
* **Local Database:** Room Database (SQLite abstraction)
* **Asynchronous Programming:** Kotlin Coroutines & Flow
* **Image Loading:** Glide / Coil
* **Navigation:** Android Navigation Component
* **Background Tasks:** WorkManager
* **Preferences:** Jetpack DataStore
* **Dependency Injection:** Manual Injection / Hilt (Ready)

## 📂 Project Structure
```text
com.example.cryptotracker
├── data             # Lidhja me API dhe Databazën
├── model            # Modelet e të dhënave (CryptoModel)
├── viewmodel        # Logjika e aplikacionit (ViewModel)
├── worker           # Proceset në prapaskenë (Njoftimet)
├── MainActivity.kt  # Hyrja kryesore
└── fragments        # Ekranet (Lista dhe Detajet)
## 🚀 Getting Started


## 🔮 Future Improvements

* Add historical charts for price analysis.
* Implement a "Favorites" list.
* Add search functionality.

---
*Created by Niman Demiraj - 2026*