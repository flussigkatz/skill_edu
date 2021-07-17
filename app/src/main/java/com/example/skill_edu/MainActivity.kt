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

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://reqres.in/api/users/2")
            .build()

        val gson = Gson()
        textview.text = "22"

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val responseBody = response.body()
                    println("!!! ${responseBody?.string()}")
                    gson.fromJson(responseBody, User::class.java)
                    runOnUiThread {
//                        textview.text = responseBody?.string()
                    }
                } catch (e: Exception) {
                    println(response)
                    e.printStackTrace()
                }
            }

        })

        fun setText(t: String) {
            textview.text = t
        }

       /*
       Executors.newSingleThreadExecutor().execute {

            val url = URL("https://reqres.in/api/users/2")
            val connection = url.openConnection() as HttpsURLConnection
            val gson = Gson()

            try {
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val line = br.readLine()
                val user = gson.fromJson(line, User::class.java)
                println("!!! ${user.data}")
            } finally {
                connection.disconnect()
            }
        }*/


    }
}