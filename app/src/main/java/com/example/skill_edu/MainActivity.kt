package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder()
            .setPrettyPrinting()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()


        val service = retrofit.create(RetrofitInterface::class.java)


        service.getUsers("users",2, 2).enqueue(object : Callback<UsersData> {
            override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {
                println("!!! ${response.body()}")
//                val answer = gson.fromJson(response.body().toString(), UsersData::class.java)
//                println(answer.data[0].email)
            }

            override fun onFailure(call: Call<UsersData>, t: Throwable) {
                println("!!!Err")
                t.printStackTrace()
            }

        })

    }
}