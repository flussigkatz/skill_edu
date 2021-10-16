package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<TextView>(R.id.text)

        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch {
            launch(Dispatchers.Default) {
                val res = getText()
                view.text = res
            }
            if (view.isAttachedToWindow) {
                Thread.sleep(5000)
            }
        }

    }

    private suspend fun getText(): String {
        return suspendCoroutine {
            Thread.sleep(5000)
            it.resume("Success")
        }
    }


}