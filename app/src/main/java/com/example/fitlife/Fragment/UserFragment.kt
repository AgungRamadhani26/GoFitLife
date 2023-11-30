package com.example.fitlife.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitlife.EditInformasiPribadiActivity
import com.example.fitlife.EditPasswordPageActivity
import com.example.fitlife.LoginPageActivity
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.databinding.FragmentUserBinding

class UserFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentUserBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentUserBinding.inflate(inflater, container, false)
        val view = binding.root

        //Menambah onclick listener
        binding.profilUbahInformasi.setOnClickListener(this)
        binding.profilUbahPassword.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when(v){
            binding.profilUbahInformasi -> {
                val intent = Intent(requireContext(), EditInformasiPribadiActivity::class.java)
                startActivity(intent)
            }
            binding.profilUbahPassword -> {
                val intent = Intent(requireContext(), EditPasswordPageActivity::class.java)
                startActivity(intent)
            }
        }
    }
}