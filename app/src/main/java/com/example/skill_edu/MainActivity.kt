package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channel = Channel<String>(Channel.BUFFERED)
        val flow = createFlow("Num")
        val flow2 = createFlow()

        CoroutineScope(EmptyCoroutineContext).launch {
            flow.collect {
                channel.send(it)
            }
            channel.close()
        }

        CoroutineScope(EmptyCoroutineContext).launch {
            launch {
                for (i in channel) {
                    println(i)
                }
            }
        }
        CoroutineScope(EmptyCoroutineContext).launch {
            launch {
                flow2.collect {
                    println(it)
                }
            }
        }


    }

    private fun createFlow(s: String): Flow<String> {
        return flow {
            repeat(5) {
                emit(s + (it + 1))
            }
        }
    }

    private fun createFlow(): Flow<String> {
        return flow {
            repeat(5) {
                emit((it + 1).toString())
            }
        }
    }


}