package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitlife.R
import com.example.fitlife.databinding.Item4Binding
import com.example.fitlife.models.resep.RecipesItem

class Adapter4(private val list: List<RecipesItem>): RecyclerView.Adapter<Adapter4.ViewHolder>() {
    // Mendapatkan data item2.xml
    class ViewHolder(val binding: Item4Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.binding.iv1)
            .load(list?.get(position)?.photo)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.iv1)
        holder.binding.tvJudul.text = list?.get(position)?.name
        holder.binding.tvSubjudul1.text = list?.get(position)?.energy.toString()
        holder.binding.tvSubjudul2.text = list?.get(position)?.duration.toString()
    }
}