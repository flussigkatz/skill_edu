package com.example.skill_edu

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.*
import java.util.*

class FirstService : Service() {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val binder = LocalBinder()

    private var isActive = false

    override fun onCreate() {
        println("!!!onCreate")
    }

    override fun onDestroy() {
        println("!!!onDestroy")
        scope.cancel()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("!!!onStartCommand")
        if (!isActive) {
            val extra = intent?.extras?.get("key")
            scope.launch {
                this@FirstService.isActive = true
                repeat(10) {
                    println("!!!$extra: $it")
                    delay(1000)
                }
                this@FirstService.isActive = false
                stopSelf()
            }
        }
        return START_NOT_STICKY
    }



    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun getRandomInt(): Int = Random().nextInt(100)

    inner class LocalBinder: Binder() {
        fun getService(): FirstService = this@FirstService
    }

}