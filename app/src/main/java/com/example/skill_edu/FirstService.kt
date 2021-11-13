package com.example.skill_edu

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class FirstService : Service() {

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        println("!!!onCreate")
    }

    override fun onDestroy() {
        println("!!!onDestroy")
        scope.cancel()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("!!!onStartCommand")
        val extra = intent?.extras?.get("key")
        scope.launch {
            repeat(10) {
                println("!!!$extra: $it")
                delay(1000)
            }
            stopSelf()
        }
        return START_NOT_STICKY
    }



    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}