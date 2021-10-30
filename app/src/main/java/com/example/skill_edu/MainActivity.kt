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

        val o = Observable.just(1, 2)
            .doOnNext {
                println("!Emit " + currentThread().name)
            }
            .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
            .observeOn(Schedulers.single())
            .map {
                println("!Map1 " + currentThread().name)
                it + it
            }
            .observeOn(Schedulers.io())
            .filter {
                println("!Filter " + currentThread().name)
                it > 1
            }
            .observeOn(Schedulers.trampoline())
            .map {
                println("!Map2 " + currentThread().name)
                it + it
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                txt.text = it.toString()
                println("!Sub " + currentThread().name)
            }


    }


}