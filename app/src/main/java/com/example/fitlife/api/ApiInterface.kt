package com.example.fitlife.api

import com.example.fitlife.models.Globe
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/news?pageSize=25")
    suspend fun getNews() : Response<Globe>
}