package com.example.fitlife.Fragment

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitlife.R
import com.example.fitlife.adapters.Adapter1
import com.example.fitlife.databinding.FragmentHomeBinding
import com.example.fitlife.models.Model1

class HomeFragment : Fragment() {
    // binding fragment_home.xml
    private lateinit var binding: FragmentHomeBinding
    // RecyclerView 1
    private lateinit var adapter1: Adapter1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // function excecuted animation
        animationRun()
        // initialitation function recyclerView
        setAdapter()
        // click
        setClick()

        return view
    }

    private fun setClick() {
        binding.btAktivitas.setOnClickListener{
            binding.btAktivitas.setBackgroundResource(R.drawable.button_active)
            binding.btKonsumsi.setBackgroundResource(R.drawable.button_nonactive)
            binding.group1.visibility = View.VISIBLE
            binding.group2.visibility = View.GONE
        }

        binding.btKonsumsi.setOnClickListener{
            binding.btKonsumsi.setBackgroundResource(R.drawable.button_active)
            binding.btAktivitas.setBackgroundResource(R.drawable.button_nonactive)
            binding.group1.visibility = View.GONE
            binding.group2.visibility = View.VISIBLE
        }
    }

    // animation
    private fun animationRun() {
        // progress bar animation
        binding.circularProgressBar.apply {
            // Set progress
            progressMax = 100f
            // animation
            setProgressWithAnimation(60f, 2000)
        }
        // animation text percantage
        val animator = ValueAnimator.ofInt(0, 60)
        animator.duration = 2000
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding.animateTextPercent.text = "$value%"
        }
        animator.start()

        // animation text kcal1
        val animator1 = ValueAnimator.ofInt(0, 600)
        animator1.duration = 2000
        animator1.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding.tvDesc1.text = "$value KCAL"
        }
        animator1.start()

        // animation text kcal2
        val animator2 = ValueAnimator.ofInt(0, 1000)
        animator2.duration = 2000
        animator2.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding.tvDesc2.text = "$value KCAL"
        }
        animator2.start()

        // animation text kcal1
        val animator3 = ValueAnimator.ofInt(0, 400)
        animator3.duration = 2000
        animator3.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding.tvDesc3.text = "$value KCAL"
        }
        animator3.start()
    }

    // recyclerView
    private fun setAdapter() {
        // recyclerView1
        val dataList: MutableList<Model1> = mutableListOf()
        // memecahkan value dataList
        judul().forEachIndexed { index, name ->
            dataList.add(Model1(name, image1().get(index), subjudul1()[index], kkal1()[index], image2().get(index), subjudul2()[index], kkal2()[index]))
        }

        // binding recyclerView1
        adapter1 = Adapter1(dataList)
        binding.recyclerView1.adapter = adapter1
    }

    // recyclerView1 function
    private fun judul(): Array<String> = resources.getStringArray(R.array.judul)
    private fun image1(): List<Int> = listOf(
        R.drawable.food1,
        R.drawable.food2,
        R.drawable.food3
    )
    private fun subjudul1(): Array<String> = resources.getStringArray(R.array.subjudul1)
    private fun kkal1(): Array<String> = resources.getStringArray(R.array.kkal1)
    private fun image2(): List<Int> = listOf(
        R.drawable.sidedish1,
        R.drawable.sidedish2,
        R.drawable.sidedish3
    )
    private fun subjudul2(): Array<String> = resources.getStringArray(R.array.subjudul2)
    private fun kkal2(): Array<String> = resources.getStringArray(R.array.kkal2)
}