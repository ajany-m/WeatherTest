package com.example.weathertest.ui

import androidx.lifecycle.viewModelScope
import com.example.weathertest.WeatherInteractor
import com.example.weathertest.base.BaseViewModel
import com.example.weathertest.base.Event
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState = ViewState(isLoading = false, temperature = "")

    override fun reduce(event: Event, previousSTATE: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonCklicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherFetchSucceed(temperature = it.temperature))
                        }
                    )
                }

                return previousSTATE.copy(isLoading = true)
            }

            is DataEvent.onWeatherFetchSucceed -> {
                return previousSTATE.copy(isLoading = false, temperature = event.temperature)
            }

            else -> return null
        }
    }

}