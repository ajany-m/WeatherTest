package com.example.weathertest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weathertest.ui.UiEvent
import com.example.weathertest.ui.ViewState
import com.example.weathertest.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherScreenViewModel by viewModel()

    private val fabWeatherFetch: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
    private val tvTemperature: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val btnWeather = findViewById<Button>(R.id.btnWeather)
        btnWeather.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also(::startActivity)
        }

        viewModel.viewState.observe(this, ::render)

        fabWeatherFetch.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonCklicked)
        }

    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        tvTemperature.text = "${viewState.temperature}"
    }

}