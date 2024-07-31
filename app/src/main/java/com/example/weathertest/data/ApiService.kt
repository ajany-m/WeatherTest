package com.example.weathertest.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getTemperature(
        @Query(QUERY_PARAM_CITY) cityName: String = "Moscow",
        // @Query(QUERY_PARAM_LON) lon: Float = 37.0F,
        @Query(QUERY_PARAM_API_KEY) appid: String = API_KEY,
    ): Single<WeatherMain>

    companion object {
        private const val QUERY_PARAM_API_KEY = "appid"
        private const val QUERY_PARAM_LAT = "lat"
        private const val QUERY_PARAM_LON = "lon"
        private const val QUERY_PARAM_CITY = "q"


    }
}