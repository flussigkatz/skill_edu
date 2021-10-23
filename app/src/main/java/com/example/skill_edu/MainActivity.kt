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


        Observable.just(1,2,3,4).map { Math.sqrt(it.toDouble()) }.filter{it % 1.0 == 0.0}
            .subscribe{ println(it.toInt())}

        /*val o = Observable.just(1,2,3, 4).filter{it % 2 != 0}

        o.doOnSubscribe { println("Sub") }
            .doOnComplete { println("End") }
            .doOnNext { println("------------") }
            .subscribe{ println(it)}*/
    }


}