package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.Item1Binding
import com.example.fitlife.models.Model1

class Adapter1(private val list: List<Model1>): RecyclerView.Adapter<Adapter1.ViewHolder>() {

    // mendapatkan data item1.xml
    class ViewHolder(val binding: Item1Binding): RecyclerView.ViewHolder(binding.root)

    // membuat data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // total keseluruhan data
    override fun getItemCount(): Int = list.size

    // mencocokan data yang di terima
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvJudul.text = this.judul
                binding.iv1.setImageResource(this.image1)
                binding.tvSubjudul1.text = this.subjudul1
                binding.tvKkal1.text = this.kkal1
                binding.iv2.setImageResource(this.image2)
                binding.tvSubjudul2.text = this.subjudul2
                binding.tvKkal2.text = this.kkal2
            }
        }
    }
}