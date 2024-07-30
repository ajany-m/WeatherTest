package com.example.weathertest

import com.example.weathertest.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    fun getWeather(): String {
        return weatherRepo.getTemperature()
    }
}