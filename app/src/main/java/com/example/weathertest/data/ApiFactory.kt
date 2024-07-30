package com.example.weathertest.data

import com.example.weathertest.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiFactory {

    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    fun getApi(): ApiService {
        return apiService
    }

}