package com.example.skill_edu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        val tv1 = findViewById<TextView>(R.id.tv1)
        val et1 = findViewById<EditText>(R.id.et1)
        val b1 = findViewById<Button>(R.id.b1)

        b1.setOnClickListener {
            tv1.text = et1.text
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv1.text = s
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }
        et1.addTextChangedListener(textWatcher)




    }

}