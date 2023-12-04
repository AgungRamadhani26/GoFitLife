package com.example.fitlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fitlife.Fragment.ClockFragment
import com.example.fitlife.Fragment.DrinkFragment
import com.example.fitlife.Fragment.GlobeFragment
import com.example.fitlife.Fragment.HomeFragment
import com.example.fitlife.Fragment.UserFragment
import com.example.fitlife.databinding.ActivityBottomNavbarBinding
import com.example.fitlife.viewModel.ViewModel

class BottomNavbarActivity : AppCompatActivity() {
    // variabel binding activity_bottom_navbar.xml
    private lateinit var binding: ActivityBottomNavbarBinding
    // variable double clicked
    private var doubleBackToExitPressedOnce = false
    private lateinit var bottomNavbarViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(HomeFragment())

        bottomNavbarViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> bottomNavbarViewModel.setFragment(HomeFragment())
                R.id.drink -> bottomNavbarViewModel.setFragment(DrinkFragment())
                R.id.clock -> bottomNavbarViewModel.setFragment(ClockFragment())
                R.id.globe -> bottomNavbarViewModel.setFragment(GlobeFragment())
                R.id.user_alt -> bottomNavbarViewModel.setFragment(UserFragment())
            }

            return@setOnItemSelectedListener true
        }

        bottomNavbarViewModel.selectedFragment.observe(this, Observer {
            setFragment(it)
        })

        // Aksi menangani tombol kembali
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!doubleBackToExitPressedOnce) {
                    doubleBackToExitPressedOnce = true
                    // jika hanya menekan sekali akan muncul toast
                    Toast.makeText(this@BottomNavbarActivity, "Tekan sekali lagi untuk keluar!!!", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        doubleBackToExitPressedOnce = false
                    }, 2000)
                } else {
                    // Menutup semua aktivitas dan memulai kembali
                    finishAffinity()
                }
            }
        }

        // menjalankan aksi function callback
        onBackPressedDispatcher.addCallback(this, callback)
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