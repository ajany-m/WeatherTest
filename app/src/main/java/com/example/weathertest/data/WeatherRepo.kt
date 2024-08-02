package com.example.weathertest.data

interface WeatherRepo {
    suspend fun getTemperature(): String
}