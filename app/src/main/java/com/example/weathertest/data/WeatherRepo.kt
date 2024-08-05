package com.example.weathertest.data

import com.example.weathertest.ui.model.WeatherModel

interface WeatherRepo {
    suspend fun getTemperature(): WeatherModel
}