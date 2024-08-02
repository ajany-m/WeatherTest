package com.example.weathertest.data

import com.example.weathertest.data.model.WeatherRemoteModel


class WeatherRemoteSource(private val api: ApiService) {
    //TODO add query

    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(cityName = "Moscow")
    }

}