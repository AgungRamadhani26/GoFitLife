package com.example.fitlife

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
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}