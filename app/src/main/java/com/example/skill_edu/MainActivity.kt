package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun stateFlow() {
            val flowForSend = MutableSharedFlow<Int>(
                replay = 1,
                onBufferOverflow = BufferOverflow.DROP_OLDEST
            )
            flowForSend.tryEmit(0)
            val stateFlow = flowForSend.distinctUntilChanged()
            CoroutineScope(EmptyCoroutineContext).launch {
                repeat(99) {
                    delay(10)
                    flowForSend.emit(it)
                }
            }

            CoroutineScope(EmptyCoroutineContext).launch {
                stateFlow.collect {
                    println("1: $it")
                }
            }
            CoroutineScope(EmptyCoroutineContext).launch {
                stateFlow.collect {
                    delay(100)
                    println("2: $it")
                }
            }
        }


        fun sharedFlow() {
            val flowForSend = MutableSharedFlow<Int>(
                extraBufferCapacity = 5,
                onBufferOverflow = BufferOverflow.DROP_OLDEST
            )
            val flowForReceive = flowForSend.asSharedFlow()
            CoroutineScope(EmptyCoroutineContext).launch {
                repeat(99) {
                    delay(1)
                    flowForSend.emit(it)
                }
            }

            CoroutineScope(EmptyCoroutineContext).launch {
                flowForReceive.collect {
                    println("1: $it")
                }
            }
            CoroutineScope(EmptyCoroutineContext).launch {
                flowForReceive.collect {
                    delay(1000)
                    println("2: $it")
                }
            }
        }
        stateFlow()
    }
}