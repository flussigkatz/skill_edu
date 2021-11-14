package com.example.skill_edu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiver = SecondReceiver()
        val iFilter = IntentFilter().also {
            it.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            it.addAction(Intent.ACTION_BATTERY_CHANGED)
        }

        registerReceiver(receiver, iFilter)

    }

    inner class SecondReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            println("!!! ${intent?.action}")
//        println("!!! Hi!")
            Toast.makeText(context, "Hi!", Toast.LENGTH_SHORT).show()
        }
    }


}