package com.example.weathertest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.weathertest.data.ApiFactory
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tvTemperature)
        val btnWeather = findViewById<Button>(R.id.btnWeather)
        btnWeather.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also(::startActivity)
        }

        val disposable = ApiFactory.apiService.getTemperature()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("TEST_OF_LOADING_DATA", "Success $it")

            }, {
                Log.d("TEST_OF_LOADING_DATA", it.message!!)
            })
    }

}