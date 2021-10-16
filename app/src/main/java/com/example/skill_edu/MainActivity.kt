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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<TextView>(R.id.text)

        val scope = CoroutineScope(EmptyCoroutineContext)
        contextToString(scope.coroutineContext)

        scope.launch {
            contextToString(coroutineContext)
            launch(Dispatchers.Main) {
                contextToString(coroutineContext)
                val res = getText()
                view.text = res
            }
        }

    }

    private suspend fun getText(): String {
        return suspendCoroutine {
            it.resume("Success")
        }
    }

    private fun contextToString(context: CoroutineContext) {
        println("${context[Job]}   ${context[ContinuationInterceptor]}")
    }


}