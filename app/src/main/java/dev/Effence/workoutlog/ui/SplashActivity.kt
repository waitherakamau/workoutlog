package dev.Effence.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
        val accessToken=sharedPrefs.getString("ACCESS_TOKEN","")
        if (accessToken!!.isNotBlank()) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
            else{


            startActivity(Intent(this, LoginActivity::class.java))
        }
       finish()
    }
}