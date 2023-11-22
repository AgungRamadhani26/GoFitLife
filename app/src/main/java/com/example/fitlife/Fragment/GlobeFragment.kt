package com.example.fitlife.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.databinding.FragmentGlobeBinding

class GlobeFragment : Fragment() {
    private lateinit var binding: FragmentGlobeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentGlobeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}