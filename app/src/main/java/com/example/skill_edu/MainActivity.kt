package com.example.skill_edu

import android.animation.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rec = findViewById<RecyclerView>(R.id.rec)

    }
}