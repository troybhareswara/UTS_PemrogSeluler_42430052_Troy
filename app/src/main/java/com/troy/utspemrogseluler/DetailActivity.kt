package com.troy.utspemrogseluler

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA      = "extra_nama"
        const val EXTRA_NIM       = "extra_nim"
        const val EXTRA_KEHADIRAN = "extra_kehadiran"
        const val EXTRA_TUGAS     = "extra_tugas"
        const val EXTRA_UTS       = "extra_uts"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolbar()
        displayData()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        findViewById<MaterialButton>(R.id.btnBack).setOnClickListener { finish() }
    }

    private fun displayData() {
        // Ambil data dari Intent (Modul 4)
        val nama      = intent.getStringExtra(EXTRA_NAMA) ?: "-"
        val nim       = intent.getStringExtra(EXTRA_NIM) ?: "-"
        val kehadiran = intent.getDoubleExtra(EXTRA_KEHADIRAN, 0.0)
        val tugas     = intent.getDoubleExtra(EXTRA_TUGAS, 0.0)
        val uts       = intent.getDoubleExtra(EXTRA_UTS, 0.0)

        // Hitung Rata-rata (Modul 5)
        val rataRata = (kehadiran + tugas + uts) / 3.0

        // If-Else: Tentukan Status Kelulusan (Modul 5)
        val status: String
        val cardColor: Int

        if (rataRata > 75) {
            status    = "✓  LULUS"
            cardColor = Color.parseColor("#1A237E")
        } else {
            status    = "✗  REMEDIAL"
            cardColor = Color.parseColor("#B71C1C")
        }

        // For Loop: Buat daftar absensi 5 hari (Modul 5)
        val absensiBuilder = StringBuilder()
        for (i in 1..5) {
            absensiBuilder.append("✔  Absensi Hari ke-$i\n")
        }
        val absensiText = absensiBuilder.toString().trimEnd()

        // Tampilkan semua hasil ke Views
        findViewById<TextView>(R.id.tvNama).text      = nama
        findViewById<TextView>(R.id.tvNim).text       = nim
        findViewById<TextView>(R.id.tvKehadiran).text = String.format(Locale.getDefault(), "%.2f", kehadiran)
        findViewById<TextView>(R.id.tvTugas).text     = String.format(Locale.getDefault(), "%.2f", tugas)
        findViewById<TextView>(R.id.tvUts).text       = String.format(Locale.getDefault(), "%.2f", uts)

        val tvStatus = findViewById<TextView>(R.id.tvStatusBadge)
        tvStatus.text = status
        tvStatus.setTextColor(Color.WHITE)

        val tvRataRata = findViewById<TextView>(R.id.tvRataRata)
        tvRataRata.text = String.format(Locale.getDefault(), "Rata-rata: %.2f", rataRata)

        // Ubah warna card status sesuai hasil if-else
        val cardStatus = findViewById<CardView>(R.id.cardStatus)
        cardStatus.setCardBackgroundColor(cardColor)

        findViewById<TextView>(R.id.tvAbsensi).text = absensiText
    }
}
