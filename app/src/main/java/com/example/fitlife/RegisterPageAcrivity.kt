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
        binding.signinToLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            //kalau button sign up di klik
            R.id.btn_sign_up -> {
                //Mengambil nilai yang dimasukkan pengguna
                val inputNama: String = binding.etNama.text.toString().trim()
                val inputEmail: String = binding.etEmail.text.toString().trim()
                val inputPassword: String = binding.etPassword.text.toString().trim()

                //validasi input
                var isErrorFields = false
                if (inputNama.isEmpty()){
                    isErrorFields = true
                    binding.etNama.error = "Field nama harus diisi"
                }else if(!inputNama.matches("^[a-zA-Z ]+\$".toRegex())){
                    isErrorFields = true
                    binding.etNama.error = "Field nama hanya dapat berisi huruf dan spasi"
                }

                if (inputEmail.isEmpty()){
                    isErrorFields = true
                    binding.etEmail.error = "Field email harus diisi"
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
                    isErrorFields = true
                    binding.etEmail.error = "Format email salah"
                }

                if (inputPassword.isEmpty()){
                    isErrorFields =true
                    binding.etPassword.error = "Password harus diisi"
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
            R.id.signin_to_login -> {
                val intent = Intent(this@RegisterPageAcrivity, LoginPageActivity::class.java)
                startActivity(intent)
            }
        }
    }
}