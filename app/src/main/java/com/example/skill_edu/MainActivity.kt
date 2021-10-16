package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.coroutines.*
import kotlinx.coroutines.delay as delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<TextView>(R.id.text)

        val scope = CoroutineScope(EmptyCoroutineContext)
        val exHand = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable.localizedMessage)
        }
        contextToString(scope.coroutineContext)

        scope.launch {
            contextToString(coroutineContext)
            launch {
                contextToString(coroutineContext)
                withContext(Dispatchers.Main) {
                    val res = runBlocking {
                        getText()
                    }
                    view.text = res
                }
            }
        }

        scope.launch {
            supervisorScope {
                launch(exHand) {
                    1 / 0
                }
            }
        }

    }

    private suspend fun getText(): String {
        return suspendCoroutine {
            Thread.sleep(3000)
            it.resume("Success")
        }
    }

    private fun contextToString(context: CoroutineContext) {
        println("${context[Job]}   ${context[ContinuationInterceptor]}")
    }


}