package com.example.fitlife.api

import com.example.fitlife.models.Globe
import com.example.fitlife.models.resep.ResponseResep
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/news?pageSize=25")
    suspend fun getNews() : Response<Globe>

    @GET ("api/recipes")
    fun getResep(): Call<ResponseResep>
}