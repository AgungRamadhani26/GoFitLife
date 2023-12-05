package com.example.fitlife.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitlife.R
import com.example.fitlife.adapters.RencanaMakanAdapter
import com.example.fitlife.databinding.FragmentClockBinding
import com.example.fitlife.models.Model1

class ClockFragment : Fragment() {
    //binding fragment clock
    private lateinit var binding: FragmentClockBinding
    // RecyclerView 1
    private lateinit var rencanaMknAdp: RencanaMakanAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentClockBinding.inflate(inflater, container, false)
        val view = binding.root

        //Button Rencana saya dan Buat rencana
        val btnRencanaSaya = binding.btnRencanaSaya
        val btnBuatRencana = binding.btnBuatRencana

        // atur latar belakang button
        btnRencanaSaya.setBackgroundResource(R.drawable.btn_theme_2)
        btnBuatRencana.setBackgroundResource(R.color.no_color)

        btnRencanaSaya.setOnClickListener{
            //atur latar belakang button
            btnRencanaSaya.setBackgroundResource(R.drawable.btn_theme_2)
            btnBuatRencana.setBackgroundResource(R.color.no_color)
        }

        btnBuatRencana.setOnClickListener{
            //atur latar belakang button
            btnRencanaSaya.setBackgroundResource(R.color.no_color)
            btnBuatRencana.setBackgroundResource(R.drawable.btn_theme_2)
        }

        // initialitation function recyclerView
        setRencanaMakanAdapter()

        return view
    }

    // recyclerView 1
    private fun setRencanaMakanAdapter() {
        val dataList: MutableList<Model1> = mutableListOf()
        // memecahkan value dataList
        judul().forEachIndexed { index, name ->
            dataList.add(Model1(name, image1().get(index), subjudul1()[index], kkal1()[index], image2().get(index), subjudul2()[index], kkal2()[index]))
        }

        // binding rvMakan
        rencanaMknAdp = RencanaMakanAdapter(dataList)
        binding.rvMakanan.adapter = rencanaMknAdp
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