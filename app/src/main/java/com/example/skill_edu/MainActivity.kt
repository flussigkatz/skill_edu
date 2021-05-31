package com.example.skill_edu

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        val tv1 = findViewById<TextView>(R.id.tv1)
        val et1 = findViewById<EditText>(R.id.et1)

        val inputFilter = InputFilter { source, start, end, dest, dstart, dend ->
            if (source.length <= 5) {
                return@InputFilter source
            }
            Toast.makeText(this, "Character limit is 5", Toast.LENGTH_SHORT).show()
            dest.toString()
        }
        val inputFilter1 = InputFilter { source, start, end, dest, dstart, dend ->
            if (source.contains("e")) {
                return@InputFilter dest
            }
            Toast.makeText(this, "No e", Toast.LENGTH_SHORT).show()
            source.toString()
        }
        et1.filters = arrayOf(InputFilter.AllCaps(), InputFilter.LengthFilter(2))




    }

}