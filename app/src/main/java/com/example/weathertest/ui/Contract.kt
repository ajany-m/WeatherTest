package com.example.weathertest.ui

import com.example.weathertest.base.Event

data class ViewState(
    val isLoading: Boolean,
    val temperature: String,
)

sealed class UiEvent() : Event {
    object OnButtonCklicked : UiEvent()
}

sealed class DataEvent : Event {
    data class onWeatherFetchSucceed(val temperature: String) : DataEvent()
    data class onWeatherFetchFailed(val error: Throwable) : DataEvent()
}