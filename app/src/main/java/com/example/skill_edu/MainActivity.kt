package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = CoroutineScope(Job())
        val jobLazy = retJobLzy(scope)

        scope.launch {
            launch {
                repeat(10) {
                    println("111 $it")
                    delay(100)
                }
            }
            val jobAsync = async {
                repeat(10) {
                    println("222 $it")
                    delay(100)
                }
                "End"
            }

            println(jobAsync.await())

            repeat(10) {
                println("333 $it")
                jobLazy.start()
                delay(100)
            }


        }
//        println("!!!!!!!!!!!!!!!!")
//        Thread.sleep(10000)
//        println("?????????????????")
    }

    private fun retJobLzy(scope: CoroutineScope): Job {
        return scope.launch(start = CoroutineStart.LAZY) {
            repeat(10) {
                println("444 $it")
                delay(100)
            }
        }
    }


}