package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var f: Provider<Feature>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerAppComponent.builder().application(this).build()

        component.inject(this)

        println("!!!${f.get()}")

        println("!!!${f.get()}")



    }


}