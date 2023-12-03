package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.Item3Binding
import com.example.fitlife.databinding.Item4Binding
import com.example.fitlife.models.Model4

class Adapter4(private val list: List<Model4>): RecyclerView.Adapter<Adapter4.ViewHolder>() {
    // Mendapatkan data item2.xml
    class ViewHolder(val binding: Item4Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.iv1.setImageResource(this.image)
                binding.tvSubjudul1.text = this.subJudul1
                binding.tvSubjudul2.text = this.subJudul2
            }
        }
    }
}