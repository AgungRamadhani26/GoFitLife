package com.example.fitlife

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.example.fitlife.databinding.ActivityRegisterPageBinding
import com.example.fitlife.databinding.ActivityRegisterProfilePageBinding

class RegisterProfilePageActivity : AppCompatActivity(), View.OnClickListener {

    //Deklarasi Binding
    private lateinit var binding: ActivityRegisterProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Melakukan view binding
        binding = ActivityRegisterProfilePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //menambah onclicklistener
        binding.btnSimpan.setOnClickListener(this)

        val tingkatAktifitas = binding.etTingkatAktifitas

        // Menyiapkan data untuk Spinner
        val options = arrayOf("Aktif", "Aktif ringan", "Cukup aktif", "Sangat aktif", "Extra aktif")

        // Menggunakan ArrayAdapter untuk menghubungkan data dengan Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Mengatur adapter ke Spinner
        tingkatAktifitas.adapter = adapter

        // Menanggapi pemilihan item pada Spinner
        tingkatAktifitas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedItem = options[position]
                // Lakukan sesuatu dengan item yang dipilih
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle ketika tidak ada item yang dipilih
            }
        }

        keyboardAction()
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.btnSimpan -> {
                val intent = Intent(this@RegisterProfilePageActivity, BottomNavbarActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun keyboardAction() {
        binding.container.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboardAndClearFocus(binding.etNama, event)
                hideKeyboardAndClearFocus(binding.etTanggalLahir, event)
                hideKeyboardAndClearFocus(binding.etTinggiBadan, event)
                hideKeyboardAndClearFocus(binding.etBeratBadan, event)
            }
            return@setOnTouchListener false
        }
    }
    private fun hideKeyboardAndClearFocus(editText: EditText, event: MotionEvent) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (editText.isFocused) {
            val outRectEditText = android.graphics.Rect()
            editText.getGlobalVisibleRect(outRectEditText)
            if (!outRectEditText.contains(event.rawX.toInt(), event.rawY.toInt())) {
                imm.hideSoftInputFromWindow(editText.windowToken, 0)
                editText.clearFocus()
            }
        }
    }
}