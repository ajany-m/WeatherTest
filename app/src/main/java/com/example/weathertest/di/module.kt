package com.example.weathertest.di

import com.example.weathertest.BASE_URL
import com.example.weathertest.WeatherInteractor
import com.example.weathertest.data.ApiService
import com.example.weathertest.data.WeatherRemoteSource
import com.example.weathertest.data.WeatherRepo
import com.example.weathertest.data.WeatherRepoImpl
import com.example.weathertest.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

    single<OkHttpClient> { OkHttpClient.Builder().build() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single<WeatherRemoteSource> { WeatherRemoteSource(get<ApiService>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeatherRepo>()) }

    single<WeatherScreenViewModel> { WeatherScreenViewModel(get<WeatherInteractor>()) }

//    fun getApi(): ApiService {
//        return apiService
//    }

}
