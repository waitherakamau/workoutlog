package dev.Effence.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.Effence.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
//    lateinit var fcvHome: FragmentContainerView
//    lateinit var bnvHome: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
                R.id.profile-> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,ProfileFragment()).commit()
                    true

                }
                else->false

            }

        }

    }
}