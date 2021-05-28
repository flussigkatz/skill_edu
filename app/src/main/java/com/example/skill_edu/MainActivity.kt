package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.skill_edu.cherdak.LifeCicleListener
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

    }

}