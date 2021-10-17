package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flowForSend = MutableSharedFlow<Int>()
        val a = 0

        CoroutineScope(EmptyCoroutineContext).launch {
                flowForSend.tryEmit(a)
        }
        val flowForReceive = flowForSend.asSharedFlow()

        CoroutineScope(EmptyCoroutineContext).launch {
            flowForReceive.collect {
                println("1: $it")
            }
        }
        CoroutineScope(EmptyCoroutineContext).launch {
            flowForReceive.collect {
                println("2: $it")
            }
        }


    }
}