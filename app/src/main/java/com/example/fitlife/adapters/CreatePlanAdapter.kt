package com.example.fitlife.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitlife.fragment.DrinkPlanFragment
import com.example.fitlife.fragment.ExercisePlanFragment
import com.example.fitlife.fragment.FoodPlanFragment

class CreatePlanAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FoodPlanFragment()
            1 -> DrinkPlanFragment()
            2 -> ExercisePlanFragment()
            else -> FoodPlanFragment()
        }
    }
}