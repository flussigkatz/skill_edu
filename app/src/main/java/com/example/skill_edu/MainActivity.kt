package com.example.skill_edu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, FirstService::class.java)
        binding.btnStart.setOnClickListener {
            intent.putExtra("key", "Value")
            startService(intent)
        }

        binding.btnStop.setOnClickListener {
            println("!!!btnStop")
            stopService(intent)
        }
    }


}