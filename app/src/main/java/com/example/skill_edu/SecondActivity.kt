package com.example.skill_edu

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.skill_edu.databinding.ActivitySecondBinding
import timber.log.Timber

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        Timber.d(.toString)
//        val bundle = intent.extras?.getBundle("bundle")
        val data = intent.extras?.get("SomeData") as SomeData
        if (data != null) {
            findViewById<TextView>(R.id.text_view_2).text =  data.toString()
//            findViewById<TextView>(R.id.text_view_2).text =  data.value1 + " " +  data.value2
        }
    }

}