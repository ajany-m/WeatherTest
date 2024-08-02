package com.example.weathertest.data

import com.example.weathertest.API_KEY
import com.example.weathertest.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apikey: String = API_KEY,
    ): WeatherRemoteModel
}