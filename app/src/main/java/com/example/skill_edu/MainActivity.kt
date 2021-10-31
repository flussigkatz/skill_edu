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
        val list1 = mutableListOf<Int>()

        for (i in 0 .. 10) {
            list1.add(i)
        }

        println("------------Start------------")

        val o1 = Observable.just(1, 2, 3)
            .take(2)
            .scan{i1, i2 ->
                i1 + i2
            }
            .subscribe {
                println("$it  o1")
            }

        val o2 = Observable.just(4, 5, 6)
            .reduce { t1, t2 -> t1 + t2 }
            .subscribe {
                println("$it  o2")
            }

        val o3 = Observable.just(7, 8, 9)
            .takeLast(2)
            .groupBy { it % 3 == 0 }
            .flatMapSingle { it.toList() }
            .subscribe{
                println("$it  o3")
            }

        val o4 = Observable.just(10, 11, 12)
            .takeUntil{it > 10}
            .subscribe{
                println("$it  o4")
            }


    }


}