package com.example.fitlife

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.fitlife.databinding.ActivityEditPasswordPageBinding

class EditPasswordPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditPasswordPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackProfile.setOnClickListener {
            val intent = Intent(this@EditPasswordPageActivity, BottomNavbarActivity::class.java)
            startActivity(intent)
        }

        keyboardAction()
    }

    private fun keyboardAction() {
        binding.container.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboardAndClearFocus(binding.etPasswordLama, event)
                hideKeyboardAndClearFocus(binding.etPasswordBaru, event)
                hideKeyboardAndClearFocus(binding.etKonfirmasiPassword, event)
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