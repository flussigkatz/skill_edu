package com.example.skill_edu.cherdak

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skill_edu.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onBackPressed() {
        val intent = Intent()
        val text = edit_text1.text.toString()
        intent.putExtra("result", text)
        setResult(0, intent)
        super.onBackPressed()
    }

}