package com.example.weatherlite

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        progressBar = findViewById(R.id.progressBar)

        // Show the ProgressBar initially
        progressBar?.visibility = View.VISIBLE

        // Delay for 5 seconds before starting MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Hide the ProgressBar
            progressBar?.visibility = View.GONE

            // Start your MainActivity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // Delay in milliseconds (5 seconds)
    }
}
