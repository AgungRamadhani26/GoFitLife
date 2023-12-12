package com.example.fitlife

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.fitlife.databinding.ActivityRegisterPageBinding


class RegisterPageAcrivity : AppCompatActivity(), View.OnClickListener {
    //Deklarasi Binding
    private lateinit var binding: ActivityRegisterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Melakukan view binding
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //menambah onclicklistener
        binding.btnSignUp.setOnClickListener(this)
        binding.signupToLogin.setOnClickListener(this)

        keyboardAction()
    }

    override fun onClick(v: View) {
        when(v){
            //kalau button sign up di klik
            binding.btnSignUp -> {
                //Mengambil nilai yang dimasukkan pengguna
                val inputEmail: String = binding.etEmail.text.toString().trim()
                val inputPassword: String = binding.etPassword.text.toString().trim()
                val inputKonfPassword: String =binding.etKonfPassword.text.toString().trim()

                //validasi input
                var isErrorFields = false

                if (inputEmail.isEmpty()){
                    isErrorFields = true
                    binding.etEmail.error = getString(R.string.email_require)
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
                    isErrorFields = true
                    binding.etEmail.error = getString(R.string.invalid_email_format)
                }

                if (inputPassword.isEmpty()){
                    isErrorFields = true
                    binding.etPassword.error = getString(R.string.password_require)
                }

                if (inputKonfPassword.isEmpty()){
                    isErrorFields = true
                    binding.etKonfPassword.error = getString(R.string.confirm_password_required)
                }else if (!inputKonfPassword.equals(inputPassword)){
                    isErrorFields = true
                    binding.etKonfPassword.error = getString(R.string.password_mismatch)
                }

                if (!isErrorFields){
                    val bundle = Bundle()
                    bundle.putString("email", inputEmail)

                    //Mengirim intent ke login page
                    val intent = Intent(this@RegisterPageAcrivity, LoginPageActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }
            binding.signupToLogin -> {
                val intent = Intent(this@RegisterPageAcrivity, LoginPageActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun keyboardAction() {
        binding.container.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboardAndClearFocus(binding.etEmail, event)
                hideKeyboardAndClearFocus(binding.etPassword, event)
                hideKeyboardAndClearFocus(binding.etKonfPassword, event)
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