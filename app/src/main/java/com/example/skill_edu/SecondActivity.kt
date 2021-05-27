package com.example.skill_edu

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.skill_edu.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_second.*
import timber.log.Timber

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