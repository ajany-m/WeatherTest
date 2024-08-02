package com.example.weathertest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.weathertest.data.ApiFactory
import com.example.weathertest.data.WeatherRemoteSource
import com.example.weathertest.data.WeatherRepoImpl
import com.example.weathertest.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var presenter: WeatherScreenPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        presenter =
            WeatherScreenPresenter(WeatherInteractor(WeatherRepoImpl(WeatherRemoteSource(ApiFactory.getApi()))))


        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val btnWeather = findViewById<Button>(R.id.btnWeather)
        btnWeather.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also(::startActivity)
        }

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                tvTemperature.text = presenter.getWeather()
            }
        }
    }

}