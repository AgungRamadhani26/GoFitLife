package com.example.fitlife.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitlife.api.ApiInterface
import com.example.fitlife.models.Globe

class NewsRepository(private val apiInterface: ApiInterface) {
    private val globeLiveData = MutableLiveData<Globe>()

    val globe: LiveData<Globe>
        get() = globeLiveData

    suspend fun getNews() {
        val result = apiInterface.getNews()
        if (result.body() != null) {
            globeLiveData.postValue(result.body())
        }
//        Log.d("result", "getGlobe: ${result}")
//        Log.d("body", "getGlobe: ${result.body()}")
    }
}