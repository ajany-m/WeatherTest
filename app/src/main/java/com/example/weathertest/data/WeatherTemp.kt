package com.example.weathertest.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherTemp(
    @SerializedName("temp")
    @Expose
    val temperature: String? = null,

    )
