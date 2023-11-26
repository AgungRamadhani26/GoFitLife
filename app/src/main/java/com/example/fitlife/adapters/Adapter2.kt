package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.Item2Binding
import com.example.fitlife.models.Model2

class Adapter2(private val list: List<Model2>): RecyclerView.Adapter<Adapter2.ViewHolder>() {

    // Mendapatkan data item2.xml
    class ViewHolder(val binding: Item2Binding): RecyclerView.ViewHolder(binding.root)

    // membuat data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // total keseluruhan data
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.ivFoto.setImageResource(this.image)
                binding.tvDeskripsi.text = this.deskripsi
            }
        }
    }
}