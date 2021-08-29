package com.example.skill_edu

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = this.getSharedPreferences("test", MODE_PRIVATE)

        shared.edit().clear().apply()

        println("!!! ${shared.getString("key", "defalut")}")

        val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key == "key") println("!!! 1")
        }
        shared.registerOnSharedPreferenceChangeListener(listener)

        shared.edit().putString("key", "Data").apply()

        println("!!! ${shared.getString("key", "defalut1")}")
    }


}