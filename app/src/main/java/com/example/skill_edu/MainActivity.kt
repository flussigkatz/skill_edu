package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Consumer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)


//        Observable.just(1,2,3,4).subscribe{ println(it.toInt())}




        /*o.doOnSubscribe { println("Sub") }
            .doOnNext { println("------------") }
            .doOnComplete {
                println("------------")
                println("End")
            }
            .subscribe { println(it) }*/
    }


}