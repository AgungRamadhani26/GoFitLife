package com.example.fitlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fitlife.databinding.ActivityLoginPageBinding
import com.example.fitlife.databinding.ActivityRegisterPageBinding

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
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_sign_in -> {
                //Mengambil nilai yang dimasukkan pengguna
                val inputEmailLogin = binding.etEmailLog.text.toString().trim()
                val inputPasswordLogin = binding.etPasswordLog.text.toString().trim()

                //validasi input
                var isInputErrLog = false
                if (inputEmailLogin.isEmpty()){
                    isInputErrLog = true
                    binding.etEmailLog.error = "Field email harus diisi"
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmailLogin).matches()){
                    isInputErrLog = true
                    binding.etEmailLog.error = "Format email salah"
                }

                if (inputPasswordLogin.isEmpty()){
                    isInputErrLog =true
                    binding.etPasswordLog.error = "Password harus diisi"
                }

                if (!isInputErrLog){
                    //Mengirim intent ke dashboard

                }
            }
            R.id.login_to_signup -> {
                val intent = Intent(this@LoginPageActivity, RegisterPageAcrivity::class.java)
                startActivity(intent)
            }
        }
    }
}