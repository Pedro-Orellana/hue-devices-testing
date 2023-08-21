package com.example.huedevicestesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.huedevicestesting.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView : NavigationView
    private lateinit var toolbar : MaterialToolbar
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.main_drawer_layout)
        navigationView = findViewById(R.id.main_navigation_view)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.testFragment),drawerLayout)

        toolbar = findViewById(R.id.main_toolbar)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        toolbar.title = "Hue Devices!"
        setSupportActionBar(toolbar)

        navigationView.setupWithNavController(navController)
        toolbar.setupWithNavController(navController, appBarConfiguration)

    }
}