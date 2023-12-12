package com.example.fitlife.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitlife.api.ApiInterface
import com.example.fitlife.models.News

class NewsRepository(private val apiInterface: ApiInterface) {
    private val newsLiveData = MutableLiveData<News>()

    val news: LiveData<News>
        get() = newsLiveData

    suspend fun getNews() {
        val result = apiInterface.getNews()
        if (result.body() != null) {
            newsLiveData.postValue(result.body())
        }
        Log.d("result", "getNews: ${result}")
        Log.d("body", "getNews: ${result.body()}")
    }
}