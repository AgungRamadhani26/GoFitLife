package com.example.fitlife.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fitlife.adapters.Adapter4
import com.example.fitlife.api.ApiUtilities
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.models.resep.RecipesItem
import com.example.fitlife.models.resep.ResponseResep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkFragment : Fragment() {
    // binding fragment_drink.xml
    private lateinit var binding: FragmentDrinkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentDrinkBinding.inflate(inflater, container, false)
        val view = binding.root

        ApiUtilities.getService().getResep().enqueue(object : Callback<ResponseResep> {
            override fun onResponse(call: Call<ResponseResep>, response: Response<ResponseResep>){
                if(response.isSuccessful){
                    val responseResep = response.body()
                    val dataResep = responseResep?.data?.recipes
                    val resepAdapter = Adapter4(dataResep as List<RecipesItem>)
                    binding.recyclerView.apply{
                        layoutManager = GridLayoutManager(requireContext(), 2)
                        setHasFixedSize(true)
                        resepAdapter.notifyDataSetChanged()
                        adapter = resepAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseResep>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
        keyboardAction()
        return view
    }

    private fun keyboardAction() {
        // Menambahkan OnTouchListener ke RecyclerView
        binding.recyclerView.setOnTouchListener { _, event ->
            // Memeriksa apakah sentuhan terjadi di luar EditText
            if (event.action == MotionEvent.ACTION_DOWN) {
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (binding.etSearch.isFocused) {
                    val outRect = android.graphics.Rect()
                    binding.etSearch.getGlobalVisibleRect(outRect)
                    if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                        // Menutup keyboard karena sentuhan terjadi di luar EditText
                        imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
                        binding.etSearch.clearFocus()
                    }
                }
            }
            return@setOnTouchListener false
        }
        // Menambahkan OnTouchListener ke ConstraintLayout
        binding.container.setOnTouchListener { _, event ->
            // Memeriksa apakah sentuhan terjadi di luar EditText dan RecyclerView
            if (event.action == MotionEvent.ACTION_DOWN) {
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (binding.etSearch.isFocused) {
                    val outRectEditText = android.graphics.Rect()
                    binding.etSearch.getGlobalVisibleRect(outRectEditText)
                    if (!outRectEditText.contains(event.rawX.toInt(), event.rawY.toInt())) {
                        // Menutup keyboard karena sentuhan terjadi di luar EditText
                        imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
                        binding.etSearch.clearFocus()
                    }
                }
            }
            return@setOnTouchListener false
        }
    }
}