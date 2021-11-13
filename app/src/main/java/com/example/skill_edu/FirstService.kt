package com.example.skill_edu

import android.app.Service
import android.content.Intent
import android.os.*

class FirstService : Service() {

    private var isActive = false

    private lateinit var messenger: Messenger

    override fun onCreate() {
        println("!!!onCreate")
    }

    override fun onDestroy() {
        println("!!!onDestroy")
    }





    override fun onBind(intent: Intent?): IBinder? {
        messenger = Messenger(IncomingHandler())
        return messenger.binder
    }


    inner class IncomingHandler: Handler() {
        override fun handleMessage(msg: Message) {
            when(msg.what) {
                1 -> println("!!!First app")
                2 -> println("!!!Second app")
                else -> super.handleMessage(msg)
            }
        }
    }

}