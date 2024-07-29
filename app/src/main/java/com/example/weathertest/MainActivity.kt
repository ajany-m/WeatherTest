package com.example.weathertest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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
    }

}