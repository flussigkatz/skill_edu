package com.example.skill_edu

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myService: Messenger
    lateinit var intent1: Intent
    private var isBound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myService = Messenger(service)
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


        intent1 = Intent(this, FirstService::class.java)
            intent1.also {
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
        binding.btnStart.setOnClickListener {
            if (!isBound) return@setOnClickListener
            val msg = Message.obtain(null, 1)
            try {
                myService.send(msg)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        binding.btnStop.setOnClickListener {
        }
    }

    override fun onDestroy() {
        intent1.also {
            unbindService(connection)
        }
        super.onDestroy()
    }


}



/*
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myService: Messenger
    lateinit var intent1: Intent
    private var isBound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myService = Messenger(service)
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

        val componentName = ComponentName("com.example.skill_edu", "com.example.skill_edu.FirstService")
        intent1 = Intent()
        intent1.also {
            it.component = componentName
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
        binding.btnStart.setOnClickListener {
            if (!isBound) return@setOnClickListener
            val msg = Message.obtain(null, 2)
            try {
                myService.send(msg)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun onDestroy() {
        intent1.also {
            unbindService(connection)
        }
        super.onDestroy()
    }


}*/
