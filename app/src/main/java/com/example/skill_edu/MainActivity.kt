package com.example.skill_edu

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import dagger.internal.DaggerCollections

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val set =
        val map = DaggerAppComponent.builder().application(this).build().getFormatters()
        Log.i("M37", "${map.get("xml")}")
        Log.i("M37", "${map.get("csv")}")

        map.forEach{_, value -> println("${value}!!!")}
    }


}