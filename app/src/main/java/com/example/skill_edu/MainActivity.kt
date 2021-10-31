package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        val txt = findViewById<TextView>(R.id.text)
        val img = findViewById<ImageView>(R.id.img)
        var index = 0

        val list = listOf(1, 2, 3)
        val arr = arrayOf(1, 2, 3)

        println("------------Start------------")

        /*val o = Observable.just(R.drawable.ic_launcher_foreground,
            R.drawable.qwe,
            R.drawable.clock,
            R.drawable.asd)
            .observeOn(Schedulers.io())
            .doOnNext {
                Thread.sleep(2000)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                img.setImageResource(it)
            }*/


        val flatMap = Observable.just(1, 2, 3)
            .flatMap {
                Observable.just(it).observeOn(Schedulers.io()).doOnNext { Thread.sleep(3000) }
            }.subscribe {
                println("${ System.currentTimeMillis() } : $it  flatMap")
                println(Thread.currentThread().name)
            }

        val concatMap = Observable.just(1, 2, 3)
            .concatMap {
                Observable.just(it).observeOn(Schedulers.io()).doOnNext { Thread.sleep(3000) }
            }.subscribe {
                println("${ System.currentTimeMillis() } : $it  concatMap")
                println(Thread.currentThread().name)
            }

        val noFlatMap = Observable.just(1, 2, 3)
            .observeOn(Schedulers.io())
            .subscribe {
                println("${ System.currentTimeMillis() } : $it  noFlatMap")
                println(Thread.currentThread().name)
                Thread.sleep(3000)
            }



    }


}