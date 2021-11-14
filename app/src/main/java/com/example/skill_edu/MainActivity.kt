package com.example.skill_edu

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var service1Intent: Intent

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service1Intent = Intent(this, FirstService::class.java)


        binding.btnStart.setOnClickListener {
            startForegroundService(service1Intent)
        }

        binding.btnStop.setOnClickListener {
            stopService(service1Intent)
        }
    }



}