package com.example.fitlife.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentUserBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}