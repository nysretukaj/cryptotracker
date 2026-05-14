Funksionalitetet Kryesore
1. Lista e Kriptomonedhave
ListFragment me RecyclerView shfaq top 20 monedhat sipas market cap. Të dhënat vijnë nga CoinGecko API (coins/markets) dhe ruhen lokalisht me Room, kështu që lista është e dukshme edhe pa internet (offline-first).
2. Ekrani i Detajeve
DetailFragment shfaq emrin, simbolin, çmimin aktual dhe logon e monedhës (me Glide). Navigimi bëhet me Navigation Component SafeArgs — të dhënat kalohen me siguri mes fragmenteve.
3. Dark Mode / Light Mode
Butoni i temës në ListFragment ndërron mes Dark/Light mode dhe preference ruhet me DataStore — mbetet e zgjedhur edhe pas mbylljes së aplikacionit.
4. Njoftimet Periodike (WorkManager)
MainActivity planifikon CryptoWorker të ekzekutohet çdo 15 minuta me PeriodicWorkRequest. Worker dërgon notifikim: "Mos harro të kontrollosh çmimin e Bitcoin sot!".
5. Foreground Service
CryptoPriceService ka infrastrukturën për të dëgjuar ndryshime çmimesh në sfond me notifikim persistent.
