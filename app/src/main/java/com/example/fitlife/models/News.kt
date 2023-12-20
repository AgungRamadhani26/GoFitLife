package com.example.fitlife.models

import com.example.fitlife.models.news.Image

data class News(
    var title: String,
    var link: String,
    var contentSnippet: String,
    var isoDate: String,
    var image: Image
)
