package com.example.skill_edu

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var index = ""
        println("start")
        val data: Uri? = this.intent.data
        if (data != null) {
           index = this.intent.dataString.toString().takeLast(7)
        }

        val uri = "https://images.pexels.com/photos/1910230/pexels-photo-$index.jpeg"

        Picasso.get()
            .load(uri)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.android_logo)
            .fit()
            .into(binding.image)

    }


}