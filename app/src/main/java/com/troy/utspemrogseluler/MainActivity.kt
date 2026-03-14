package com.troy.utspemrogseluler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: TextInputEditText
    private lateinit var etNim: TextInputEditText
    private lateinit var etKehadiran: TextInputEditText
    private lateinit var etTugas: TextInputEditText
    private lateinit var etUts: TextInputEditText
    private lateinit var btnGenerate: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupButton()
    }

    private fun initViews() {
        etNama      = findViewById(R.id.etNama)
        etNim       = findViewById(R.id.etNim)
        etKehadiran = findViewById(R.id.etKehadiran)
        etTugas     = findViewById(R.id.etTugas)
        etUts       = findViewById(R.id.etUts)
        btnGenerate = findViewById(R.id.btnGenerate)
    }

    private fun setupButton() {
        btnGenerate.setOnClickListener {
            if (validateInput()) {
                navigateToDetail()
            }
        }
    }

    private fun validateInput(): Boolean {
        val nama      = etNama.text.toString().trim()
        val nim       = etNim.text.toString().trim()
        val kehadiran = etKehadiran.text.toString().trim()
        val tugas     = etTugas.text.toString().trim()
        val uts       = etUts.text.toString().trim()

        if (nama.isEmpty()) {
            etNama.error = getString(R.string.error_field_required)
            etNama.requestFocus()
            return false
        }
        if (nim.isEmpty()) {
            etNim.error = getString(R.string.error_field_required)
            etNim.requestFocus()
            return false
        }
        if (kehadiran.isEmpty()) {
            etKehadiran.error = getString(R.string.error_field_required)
            etKehadiran.requestFocus()
            return false
        }
        if (tugas.isEmpty()) {
            etTugas.error = getString(R.string.error_field_required)
            etTugas.requestFocus()
            return false
        }
        if (uts.isEmpty()) {
            etUts.error = getString(R.string.error_field_required)
            etUts.requestFocus()
            return false
        }

        val nilaiKehadiran = kehadiran.toDoubleOrNull()
        val nilaiTugas     = tugas.toDoubleOrNull()
        val nilaiUts       = uts.toDoubleOrNull()

        if (nilaiKehadiran == null || nilaiKehadiran < 0 || nilaiKehadiran > 100) {
            etKehadiran.error = getString(R.string.error_nilai_range)
            etKehadiran.requestFocus()
            return false
        }
        if (nilaiTugas == null || nilaiTugas < 0 || nilaiTugas > 100) {
            etTugas.error = getString(R.string.error_nilai_range)
            etTugas.requestFocus()
            return false
        }
        if (nilaiUts == null || nilaiUts < 0 || nilaiUts > 100) {
            etUts.error = getString(R.string.error_nilai_range)
            etUts.requestFocus()
            return false
        }

        return true
    }

    private fun navigateToDetail() {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_NAMA,      etNama.text.toString().trim())
            putExtra(DetailActivity.EXTRA_NIM,       etNim.text.toString().trim())
            putExtra(DetailActivity.EXTRA_KEHADIRAN, etKehadiran.text.toString().trim().toDouble())
            putExtra(DetailActivity.EXTRA_TUGAS,     etTugas.text.toString().trim().toDouble())
            putExtra(DetailActivity.EXTRA_UTS,       etUts.text.toString().trim().toDouble())
        }
        startActivity(intent)
    }
}
