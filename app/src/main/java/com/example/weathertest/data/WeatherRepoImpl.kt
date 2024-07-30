package com.example.weathertest.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override fun getTemperature(): String {
        return weatherRemoteSource.getWeather().toString()
    }
}