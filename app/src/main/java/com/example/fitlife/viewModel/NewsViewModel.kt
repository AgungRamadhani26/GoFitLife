package com.example.fitlife.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitlife.models.News
import com.example.fitlife.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNews()
        }
    }

    val news: LiveData<News>
        get() = newsRepository.news
}