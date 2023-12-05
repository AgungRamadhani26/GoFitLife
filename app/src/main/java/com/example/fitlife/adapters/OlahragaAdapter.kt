package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.ItemOlahragaBinding
import com.example.fitlife.models.Olahraga

class OlahragaAdapter(private val list: List<Olahraga>): RecyclerView.Adapter<OlahragaAdapter.ViewHolder>() {
    // mendapatkan data item_rencana_makan.xml
    class ViewHolder(val binding: ItemOlahragaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOlahragaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvNamaOlahraga.text = this.nama_olahraga
                binding.ivOlahraga.setImageResource(this.img_olahraga)
                binding.tvLamaOlahraga.text = this.lama_waktu_olahraga
                binding.tvWaktuOlahrga.text = this.waktu_olahraga
            }
        }
    }
}