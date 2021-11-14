package com.example.skill_edu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        println("!!! ${intent?.action}")
//        println("!!! Hi!")
        Toast.makeText(context, "Hi!", Toast.LENGTH_SHORT).show()
    }
}