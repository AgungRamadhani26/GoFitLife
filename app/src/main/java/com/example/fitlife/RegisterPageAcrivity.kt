package com.example.fitlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                    binding.etEmail.error = "Field email harus diisi"
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
                    isErrorFields = true
                    binding.etEmail.error = "Format email salah"
                }

                if (inputPassword.isEmpty()){
                    isErrorFields = true
                    binding.etPassword.error = "Password harus diisi"
                }

                if (inputKonfPassword.isEmpty()){
                    isErrorFields = true
                    binding.etKonfPassword.error = "Konfirmasi password harus diisi"
                }else if (!inputKonfPassword.equals(inputPassword)){
                    isErrorFields = true
                    binding.etKonfPassword.error = "Konfirmasi password tidak match dengan password"
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
}