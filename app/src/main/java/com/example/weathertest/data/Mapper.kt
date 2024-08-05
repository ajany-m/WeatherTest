package com.example.weathertest.data

import com.example.weathertest.data.model.WeatherRemoteModel
import com.example.weathertest.ui.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.main.temperature
)