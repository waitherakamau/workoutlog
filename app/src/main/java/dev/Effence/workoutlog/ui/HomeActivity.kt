package dev.Effence.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.Effence.workoutlog.R
import dev.Effence.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences
//    lateinit var fcvHome: FragmentContainerView
//    lateinit var bnvHome: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.tvLogout.setOnClickListener {
        startActivity(Intent(this,LoginActivity::class.java))
        logoutRequest()

    }
        castViews()
        setBottomNav()
    }

    fun castViews() {
        binding.fcvHome

        binding.bnvHome
    }

    fun setBottomNav() {
       binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    val transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome, planFragment())
                    true
                }

                R.id.track -> {
                    val transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment())
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        ProfileFragment()
                    ).commit()
                    true

                }
                else->false

            }

        }

    }
    fun logoutRequest(){
        sharedPrefs.edit().clear().commit()
    }
}