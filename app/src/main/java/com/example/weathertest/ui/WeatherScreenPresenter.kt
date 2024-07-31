package com.example.weathertest.ui

import com.example.weathertest.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {
    suspend fun getWeather(): String {
        return interactor.getWeather()
    }

}