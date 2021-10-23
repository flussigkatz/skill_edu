package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Consumer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Start")


        val flow = object : Observable<Int>() {
            override fun subscribeActual(observer: Observer<in Int>) {
                observer.onNext(5)
                observer.onNext(3)
                observer.onNext(4)
                observer.onComplete()
            }
        }

        val subscriber = Consumer<Int> { println(it) }

        val d = flow.subscribe(subscriber)

        d.dispose()


    }


}