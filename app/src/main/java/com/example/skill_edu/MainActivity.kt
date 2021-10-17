package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channel = Channel<String>(Channel.BUFFERED)
        val flow = createFlow("Num").take(6)
        val flow2 = createFlow().transform {
            emit(it + it)
        }

        CoroutineScope(EmptyCoroutineContext).launch {
            flow.collect {
                channel.send(it)
            }
            println("first " + flow.first())
            println("last " + flow.last())
            try {
                println("single " + flow.single())
            } catch (e: Exception) {
                println(e)
            }
            val reduce = flow2.reduce { accumulator, value ->
                accumulator + value
            }
            println("reduce $reduce")

            val fold = flow2.fold("Sum: ", {a, b -> a + b})

            println("reduce $fold")//?????????

            channel.close()
        }

        CoroutineScope(EmptyCoroutineContext).launch {
            launch {
                for (i in channel) {
//                    println(i)
                }
            }
        }
        CoroutineScope(EmptyCoroutineContext).launch {
            launch {
                flow2.collect {
//                    println(it)
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

    private fun createFlow(): Flow<Int> {
        return flow {
            repeat(5) {
                emit((it + 1))
            }
        }
    }


}