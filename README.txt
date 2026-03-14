# UTS_PemrogSeluler_42430052_Troy
## Aplikasi Generator Lembar Penilaian

### CARA IMPORT KE ANDROID STUDIO
=====================================================

1. Extract file ZIP ini ke folder mana saja di komputer kamu
   (misal: D:\AndroidProjects\UTS_PemrogSeluler_42430052_Troy)

2. Buka Android Studio

3. Klik "Open" (bukan New Project)

4. Arahkan ke folder hasil extract tadi, lalu klik "OK"

5. Tunggu Gradle Sync selesai (bisa 2-5 menit tergantung koneksi)
   - Jika muncul popup "Gradle Sync", klik "OK" / "Sync Now"

6. Setelah sync selesai, klik tombol RUN ▶ (Shift+F10)

7. Pilih emulator atau sambungkan HP Android dengan USB Debugging aktif

### STRUKTUR FILE
=====================================================
app/src/main/
├── AndroidManifest.xml
├── java/com/troy/utspemrogseluler/
│   ├── MainActivity.kt         ← Form input utama
│   └── DetailActivity.kt       ← Hasil penilaian
└── res/
    ├── layout/
    │   ├── activity_main.xml   ← Layout portrait
    │   └── activity_detail.xml ← Layout detail
    ├── layout-land/
    │   └── activity_main.xml   ← Layout landscape (2 kolom)
    ├── values/
    │   ├── strings.xml
    │   └── themes.xml
    └── drawable/
        ├── circle_bg.xml
        ├── ic_arrow_back.xml
        └── ic_launcher_foreground.xml

### FITUR APLIKASI
=====================================================
- Form input: Nama, NIM, Nilai Kehadiran, Tugas, UTS
- Validasi input (field kosong & range nilai 0-100)
- UI Responsif: Portrait (vertikal) & Landscape (2 kolom)
- Intent: Kirim data dari MainActivity ke DetailActivity
- If-Else: Rata-rata > 75 = LULUS, selainnya = REMEDIAL
- For Loop: Generate 5 baris absensi otomatis
- ScrollView pada halaman detail

### INFORMASI PROJECT
=====================================================
Nama Project : UTS_PemrogSeluler_42430052_Troy
Package      : com.troy.utspemrogseluler
Min SDK      : API 24 (Android 7.0)
Target SDK   : API 34 (Android 14)
Language     : Kotlin
