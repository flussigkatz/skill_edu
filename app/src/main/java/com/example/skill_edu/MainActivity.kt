package com.example.skill_edu

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firstService: FirstService
    private var isBound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as FirstService.LocalBinder
            firstService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = Intent(this, FirstService::class.java)
            intent.also {
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
        binding.btnStart.setOnClickListener {
            println("!!!btnStart")
            if (!isBound) return@setOnClickListener
            binding.txt.text = firstService.getRandomInt().toString()
        }

        binding.btnStop.setOnClickListener {
            println("!!!btnStop")
//            stopService(intent)
        }
    }

    override fun onDestroy() {
        intent.also {
            unbindService(connection)
        }
        super.onDestroy()
    }


}