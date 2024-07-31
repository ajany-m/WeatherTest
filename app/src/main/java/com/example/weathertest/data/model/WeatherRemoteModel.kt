package com.example.weathertest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    @Expose
    val main: WeatherMainRemoteModel,
)
