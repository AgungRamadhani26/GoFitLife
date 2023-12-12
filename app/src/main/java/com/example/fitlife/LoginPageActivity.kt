package com.example.fitlife

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.fitlife.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity(), View.OnClickListener {
    //Deklarasi Binding
    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Melakukan view binding
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Menampilkan email pada halaman login page
        val bundle = intent.extras
        if (bundle != null){
            binding.etEmailLog.setText(bundle.getString("email"))
        }

        //menambah onclicklistener
        binding.btnSignIn.setOnClickListener(this)
        binding.loginToSignup.setOnClickListener(this)
        binding.tvLupaKataSandi.setOnClickListener(this)

        keyboardAction()
    }

    override fun onClick(v: View) {
        when(v){
            binding.btnSignIn -> {
                //Mengambil nilai yang dimasukkan pengguna
                val inputEmailLogin = binding.etEmailLog.text.toString().trim()
                val inputPasswordLogin = binding.etPasswordLog.text.toString().trim()

                //validasi input
                var isInputErrLog = false
                if (inputEmailLogin.isEmpty()){
                    isInputErrLog = true
                    binding.etEmailLog.error = getString(R.string.email_require)
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmailLogin).matches()){
                    isInputErrLog = true
                    binding.etEmailLog.error = getString(R.string.invalid_email_format)
                }

                if (inputPasswordLogin.isEmpty()){
                    isInputErrLog =true
                    binding.etPasswordLog.error = getString(R.string.password_require)
                }

                if (!isInputErrLog){
                    //Mengirim intent ke dashboard
                    val intent = Intent(this@LoginPageActivity, RegisterProfilePageActivity::class.java)
                    startActivity(intent)

                }
            }
            binding.tvLupaKataSandi ->{
                val intent = Intent(this@LoginPageActivity, EditPasswordPageActivity::class.java)
                startActivity(intent)
            }
            binding.loginToSignup -> {
                val intent = Intent(this@LoginPageActivity, RegisterPageAcrivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun keyboardAction() {
        binding.container.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboardAndClearFocus(binding.etEmailLog, event)
                hideKeyboardAndClearFocus(binding.etPasswordLog, event)
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