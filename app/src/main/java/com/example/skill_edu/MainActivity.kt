package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))
        val main = findViewById<CoordinatorLayout>(R.id.main)
        val snackbar = Snackbar.make(main, "Hello", Snackbar.LENGTH_SHORT)
        snackbar.setAction("Acction"){
            Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
        }
        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.design_default_color_error))
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            snackbar.show()
        }
    }
}