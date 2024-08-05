package com.example.weathertest

import com.example.weathertest.base.Either
import com.example.weathertest.base.attempt
import com.example.weathertest.data.WeatherRepo
import com.example.weathertest.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}