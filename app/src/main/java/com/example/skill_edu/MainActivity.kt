package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
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

        for (i in 0..10) {
            list1.add(i)
        }

        println("------------Start------------")

        /*val o1 = Observable.create<Int> { sub ->
            btn.setOnClickListener {
                sub.onNext(++index)
                btn.text = index.toString()
            }
        }.debounce(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                txt.text = it.toString()
            }*/

        /*val o1 = Observable.create<Int> { sub ->
            btn.setOnClickListener {
                sub.onNext(++index)
                btn.text = index.toString()
            }
        }.throttleLatest(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                txt.text = it.toString()
            }*/

        /*val o1 = Observable.create<Int> { sub ->
            btn.setOnClickListener {
                sub.onNext(++index)
                btn.text = index.toString()
            }
        }.window(2, TimeUnit.SECONDS)
            .flatMapSingle { it.toList() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                txt.text = it.toString()
            }*/

        /*val o1 = Observable.create<Int> { sub ->
            btn.setOnClickListener {
                sub.onNext(++index)
                btn.text = index.toString()
            }
        }.sample(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                txt.text = it.toString()
            }*/

        val o1 = Flowable.create<Int>({ sub ->
            btn.setOnClickListener {
                for(i in 1 .. 100) {
                    sub.onNext(++index)
                }
                btn.text = index.toString()
            }
        }, BackpressureStrategy.DROP)
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            txt.text = it.toString()
        }




    }


}