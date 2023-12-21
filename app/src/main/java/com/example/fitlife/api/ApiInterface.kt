package com.example.fitlife.api

import com.example.fitlife.models.Globe
import com.example.fitlife.models.register.ResponseRegister
import com.example.fitlife.models.resep.ResponseResep
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("api/news?pageSize=25")
    suspend fun getNews() : Response<Globe>

    @GET ("api/recipes")
    fun getResep(): Call<ResponseResep>

    @GET("images/{image_id}")
    fun getPotoResep(@Path("image_id") imageId: String?): Call<ResponseBody>

    @POST("register")
    fun registerUser(@Body request: ResponseRegister): Call<ResponseBody>
}