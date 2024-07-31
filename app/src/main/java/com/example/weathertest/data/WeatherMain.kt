package com.example.weathertest.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherMain(
    @SerializedName("main")
    @Expose
    val data: WeatherTemp? = null,
)
