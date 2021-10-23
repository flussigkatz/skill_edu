package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.function.Consumer
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Start")

        val observable = object : Observable<Int>() {
            override fun subscribeActual(observer: Observer<in Int>) {
//                observer.onSubscribe()
                observer.onNext(1)
                observer.onNext(2)
                observer.onNext(3)
                observer.onNext(4)
                observer.onNext(5)
                observer.onComplete()
            }

        }

        val observer = object : Observer<Int> {
            var i = 1
            override fun onSubscribe(d: Disposable) {
                println("Sub")
            }

            override fun onNext(t: Int) {
                println("value $i: $t")
                i++
            }

            override fun onError(e: Throwable) {
//                e.printStackTrace()
                println(e.localizedMessage)
            }

            override fun onComplete() {
                println("Complete")
            }

        }

        val d = observable.subscribe(observer)

//        d.dispose()


    }


}