package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson = Gson()

        Executors.newSingleThreadExecutor().execute {

            val url = URL("https://reqres.in/api/users/2")
            val connection = url.openConnection() as HttpsURLConnection


            try {
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val line = br.readLine()
                val user = gson.fromJson(line, User::class.java)
                println("!!! ${line}")
                println("!!! ${user.data.firstName}")
                runOnUiThread {
//                    textview.text = user.data.firstName
                }
            } finally {
                connection.disconnect()
            }

        }


        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://reqres.in/api/users/2")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val responseBodyString = response.body()?.string()
                    println("!!! ${responseBodyString}")
                    val user2 = gson.fromJson(responseBodyString, User::class.java)
                    println("!!! ${user2.data.firstName}")
                    runOnUiThread {
                        textview.text = user2.data.firstName
                    }
                } catch (e: Exception) {
                    println(response)
                    e.printStackTrace()
                }
            }

        })
    }
}