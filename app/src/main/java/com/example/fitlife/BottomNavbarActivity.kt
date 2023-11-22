package com.example.fitlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitlife.Fragment.ClockFragment
import com.example.fitlife.Fragment.DrinkFragment
import com.example.fitlife.Fragment.GlobeFragment
import com.example.fitlife.Fragment.HomeFragment
import com.example.fitlife.Fragment.UserFragment
import com.example.fitlife.databinding.ActivityBottomNavbarBinding

class BottomNavbarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> setFragment(HomeFragment())
                R.id.drink -> setFragment(DrinkFragment())
                R.id.clock -> setFragment(ClockFragment())
                R.id.globe -> setFragment(GlobeFragment())
                R.id.user_alt -> setFragment(UserFragment())
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction =supportFragmentManager.beginTransaction()
        // menukar fragment
        transaction.replace(R.id.fragmentFl, fragment)
        // untuk tidak menumpuk fragment
        transaction.disallowAddToBackStack()
        // menyatakan transaction di jalankan
        transaction.commit()
    }
}