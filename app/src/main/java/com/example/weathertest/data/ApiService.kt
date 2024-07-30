package com.example.weathertest.data

import com.example.weathertest.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast")
    fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") apikey: String = API_KEY,
    )
}