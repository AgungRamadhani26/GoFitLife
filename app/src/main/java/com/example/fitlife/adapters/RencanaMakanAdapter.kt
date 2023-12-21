package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.ItemRencanaMakananBinding

import com.example.fitlife.models.home.Model1

class RencanaMakanAdapter(private val list: List<Model1>): RecyclerView.Adapter<RencanaMakanAdapter.ViewHolder>() {

    // mendapatkan data item_rencana_makan.xml
    class ViewHolder(val binding: ItemRencanaMakananBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRencanaMakananBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvWaktuMkn.text = this.judul
                binding.iv1Makanan.setImageResource(this.image1)
                binding.tvNamaMakanan1.text = this.subjudul1
                binding.tvJumlahKalori1.text = this.kkal1
                binding.iv2Makanan.setImageResource(this.image2)
                binding.tvNamaMakanan2.text = this.subjudul2
                binding.tvJumlahKalori2.text = this.kkal2
            }
        }
    }
}