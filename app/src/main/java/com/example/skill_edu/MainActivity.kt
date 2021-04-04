package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val root = findViewById<ViewGroup>(R.id.root)
//        val view = layoutInflater.inflate(R.layout.item, root, false)
//        root.addView(view)
        /*val view1 = layoutInflater.inflate(R.layout.activity_main, root, false)
        view1.visibility = View.INVISIBLE
        val view2 = layoutInflater.inflate(R.layout.activity_main, root, false)
        view2.isEnabled = false
        val view3 = layoutInflater.inflate(R.layout.activity_main, root, true)
        view3.setBackgroundColor(resources.getColor(R.color.design_default_color_error))
        view3.setOnClickListener{}
        root.addView(view1)
        root.addView(view2)*/
    }

}