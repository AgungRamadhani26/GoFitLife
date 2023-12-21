package com.example.fitlife.adapters.homeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.Item3Binding
import com.example.fitlife.models.home.Model3

class Adapter3(private val list: List<Model3>): RecyclerView.Adapter<Adapter3.ViewHolder>(){
    // Mendapatkan data item2.xml
    class ViewHolder(val binding: Item3Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
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