package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlin.coroutines.*
import kotlinx.coroutines.delay as delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val broadcastChannel = BroadcastChannel<Int>(10)

        CoroutineScope(EmptyCoroutineContext).launch {

            repeat(9) {
                delay(100)
                broadcastChannel.send(it)
            }
        }

        CoroutineScope(EmptyCoroutineContext).launch {
            delay(1000)
            val channel = broadcastChannel.openSubscription()
            for (i in channel) {
                println(i)
            }
        }

    }


}