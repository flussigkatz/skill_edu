package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        val data =  Data("ava",
            "email",
            "Ivan",
            666,
            "Ivanov")
        val toJson = gson.toJson(data)
        println("!!! $toJson")


    }

    data class Data(
        val avatar: String,
        val email: String,
        val firstName: String,
        val id: Int,
        val lastName: String
    )


}