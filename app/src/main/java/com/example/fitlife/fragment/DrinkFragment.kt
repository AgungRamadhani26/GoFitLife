package com.example.fitlife.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.fitlife.R
import com.example.fitlife.adapters.Adapter4
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.models.Model4

class DrinkFragment : Fragment() {
    // binding fragment_drink.xml
    private lateinit var binding: FragmentDrinkBinding
    // RecyclerView
    private lateinit var adapter4: Adapter4

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentDrinkBinding.inflate(inflater, container, false)
        val view = binding.root

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
        binding.constraintLayout.setOnTouchListener { _, event ->
            // Memeriksa apakah sentuhan terjadi di luar EditText dan RecyclerView
            if (event.action == MotionEvent.ACTION_DOWN) {
                val imm =
                    context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
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

        setAdapter()
        return view
    }

    private fun hideKeyboard(view: View) {
        val imm = context?.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun setAdapter() {
        val dataList: MutableList<Model4> = mutableListOf()
        // Iterasi menggunakan image() sebagai referensi
        image().forEachIndexed { index, name ->
            dataList.add(Model4(name, judul()[index], subJudul1()[index], subJudul2()[index]))
        }
        // Set adapter untuk RecyclerView
        adapter4 = Adapter4(dataList)
        binding.recyclerView.adapter = adapter4
    }

    private fun image(): List<Int> = listOf(
        R.drawable.food4,
        R.drawable.food5,
        R.drawable.food6,
        R.drawable.food7,
        R.drawable.food8,
        R.drawable.food9,
        R.drawable.food10,
        R.drawable.food11,
        R.drawable.food12,
        R.drawable.food13,
    )

    private fun judul(): Array<String> = resources.getStringArray(R.array.judul2)
    private fun subJudul1(): Array<String> = resources.getStringArray(R.array.subjudul3)
    private fun subJudul2(): Array<String> = resources.getStringArray(R.array.subjudul4)
}