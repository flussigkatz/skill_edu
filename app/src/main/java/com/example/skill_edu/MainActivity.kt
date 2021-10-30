package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.lang.Thread.currentThread
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        val txt = findViewById<TextView>(R.id.text)
        var index = 0

        println("------------Start------------")

        val o = Observable.just("1", "2", "Head", "Dog")
            .map { it.lowercase() }
            .filter{ it.contains("d")}
            .subscribe {
                println("!Sub ${it.uppercase()}")
            }


    }


}