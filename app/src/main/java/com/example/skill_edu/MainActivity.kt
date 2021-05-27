package com.example.skill_edu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import timber.log.Timber
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")
        val intent = Intent(this, SecondActivity::class.java)
        findViewById<Button>(R.id.change_text).setOnClickListener {
            startActivityForResult(intent, 77)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data == null) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show()
            return

        }
        if (requestCode == 77){
            if (resultCode == 0) {
                val string = "${textview.text} ${data?.getStringExtra("result")}"
                textview.text = string
                Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
            }
        }
    }
}