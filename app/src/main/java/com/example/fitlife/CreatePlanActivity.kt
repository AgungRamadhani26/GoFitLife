package com.example.fitlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fitlife.adapters.CreatePlanAdapter
import com.example.fitlife.databinding.ActivityCreatePlanBinding
import com.example.fitlife.databinding.ActivityLoginPageBinding
import com.example.fitlife.databinding.ActivityRegisterPageBinding
import com.google.android.material.tabs.TabLayout
import java.util.Objects

class CreatePlanActivity : AppCompatActivity() {
    //Deklarasi Binding
    private lateinit var binding: ActivityCreatePlanBinding
    private lateinit var createPlanAdapter: CreatePlanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Melakukan view binding
        binding = ActivityCreatePlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createPlanAdapter = CreatePlanAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = createPlanAdapter

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }
}