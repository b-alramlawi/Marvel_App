package com.bahaa.marvelapp.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        installSplashScreen()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){

        binding?.apply {
            val navView: BottomNavigationView = bottomNavigationView

            val navController = findNavController(R.id.fragment_host)
            navView.setupWithNavController(navController)
        }

    }
}

