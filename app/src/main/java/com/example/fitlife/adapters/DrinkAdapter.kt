package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitlife.R
import com.example.fitlife.api.ApiUtilities
import com.example.fitlife.databinding.Item4Binding
import com.example.fitlife.models.resep.RecipesItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkAdapter(private val list: List<RecipesItem>): RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {
    // Mendapatkan data item2.xml
    class ViewHolder(val binding: Item4Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Item4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageId = list?.get(position)?.photo
//        Log.d("dataResep", "getGlobe: ${photoId}")
        // Panggil metode Retrofit untuk mendapatkan foto
        val apiService = ApiUtilities.getService()
        val call = apiService.getPotoResep(imageId)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Dapatkan foto sebagai ResponseBody
                    val photoBody = response.body()

                    // Lakukan sesuatu dengan foto, misalnya, tampilkan menggunakan Glide
                    Glide.with(holder.binding.iv1)
                        .load(photoBody)
                        .error(R.drawable.ic_launcher_background)
                        .into(holder.binding.iv1)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        holder.binding.tvJudul.text = list?.get(position)?.name
        holder.binding.tvSubjudul1.text = list?.get(position)?.energy.toString()
        holder.binding.tvSubjudul2.text = list?.get(position)?.duration.toString()
    }
}