package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        var index = 0


        val o1 = Observable.interval(1, TimeUnit.SECONDS)
        val cO = o1.replay()
        val s1 =cO.subscribe{ println("s1: $it") }

        Thread.sleep(3000)

        val s2 = cO.subscribe{ println("s2: $it") }
        cO.connect()


        Thread.sleep(3000)


        val o = ReplaySubject.create<Int>()
        o.subscribe{ println(it)}

        btn.setOnClickListener {
                o.onNext(++index)
            s1.dispose()
            s2.dispose()
            val s3 = cO.subscribe{ println("s3: $it") }
        }

    }


}