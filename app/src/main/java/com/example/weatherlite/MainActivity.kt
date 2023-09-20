package com.example.weatherlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.example.weatherlite.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    private val TAG = "MainActivity" // Define TAG as a string variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchWeatherData("Karachi")
        searchCity()
    }

    private fun searchCity() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun fetchWeatherData(cityName: String) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

        val response = retrofit.getWeatherData(cityName, "5721bcab288240817dd1837c58184661", "metric")

        response.enqueue(object : Callback<weatherApp> {
            override fun onResponse(call: Call<weatherApp>, response: Response<weatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val weatherData = responseBody

                    // Extract relevant weather information
                    val temperature = weatherData.main.temp.toString()
                    val humidity = weatherData.main.humidity
                    val windSpeed = weatherData.wind.speed
                    val sunRise = weatherData.sys.sunrise.toLong()
                    val sunSet = weatherData.sys.sunset.toLong()
                    val seaLevel = weatherData.main.pressure
                    val condition = weatherData.weather.firstOrNull()?.main ?: "unknown"
                    val tempMax = weatherData.main.temp_max
                    val tempMin = weatherData.main.temp_min

                    // Update UI elements with weather information
                    binding.teampature.text = "$temperature °C"
                    binding.weather.text = condition
                    binding.mixTemp.text = "Max Temp: $tempMax °C"
                    binding.minTemp.text = "Min Temp: $tempMin °C"
                    binding.humidity.text = "$humidity %"
                    binding.windspeed.text = "$windSpeed m/s"
                    binding.sunrise.text = "${time(sunRise)}"
                    binding.sunset.text = "${time(sunSet)}"
                    binding.sea.text = "$seaLevel hPa"
                    binding.conduction.text = condition
                    binding.day.text = dayName(System.currentTimeMillis())
                    binding.date.text = date()
                    binding.cityname.text = "$cityName"
//
                    // Change image according to weather condition
                    changeImageAccordingToWeatherCondition(condition)
                }
            }

            private fun date(): String {
                val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
                return sdf.format(Date())
            }

            private fun time(timestamp: Long): String {
                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                return sdf.format(Date(timestamp * 1000))
            }

            override fun onFailure(call: Call<weatherApp>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

            private fun changeImageAccordingToWeatherCondition(condition: String) {
                val binding = binding // Resolve binding inside the function

                when (condition) {
                    "Clear Sky", "Sunny", "Clear" -> {
                        binding.root.setBackgroundResource(R.drawable.bgsun)
                        binding.sun.setAnimation(R.raw.sun_animation)
                    }

                    "Partly Cloudy", "Clouds", "Overcast", "Mist", "Foggy", "Haze" -> {
                        binding.root.setBackgroundResource(R.drawable.bgcloudy)
                        binding.sun.setAnimation(R.raw.coludy_animation)
                    }

                    "Light Rain", "Drizzle", "Moderate Rain", "Showers", "Smoke", "Heavy Rain" -> {
                        binding.root.setBackgroundResource(R.drawable.bgrain)
                        binding.sun.setAnimation(R.raw.rain_animation)
                    }

                    "Light Snow", "Blizzard", "Moderate Snow", "Heavy Snow" -> {
                        binding.root.setBackgroundResource(R.drawable.bgsnow)
                        binding.sun.setAnimation(R.raw.snow_animation)
                    }

                    else -> {
                        binding.root.setBackgroundResource(R.drawable.bgsun)
                        binding.sun.setAnimation(R.raw.sun_animation)
                    }
                }
//
                binding.sun.playAnimation()
            }

        })
    }

    private fun dayName(timestamp: Long): String {
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}
