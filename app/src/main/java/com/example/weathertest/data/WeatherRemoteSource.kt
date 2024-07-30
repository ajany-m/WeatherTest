package com.example.weathertest.data


class WeatherRemoteSource(private val api: ApiService) {
    //TODO add query

    fun getWeather() {
        return api.getWeather(lat = "55", lon = "37")
    }

}