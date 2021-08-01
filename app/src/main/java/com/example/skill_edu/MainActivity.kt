package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.skill_edu.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val link = "https://memepedia.ru/wp-content/uploads/2018/12/in_article_11341c19c0-768x768.jpg"

        Picasso.get()
            .load(link)
            .fit()
            .placeholder(R.drawable.android_logo)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)
    }
}