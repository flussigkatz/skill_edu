package com.example.skill_edu

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.transition.Visibility.MODE_IN
import android.transition.Visibility.MODE_OUT
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TableRow
import androidx.annotation.IntDef
import androidx.appcompat.app.AppCompatActivity
import androidx.core.transition.addListener
import androidx.core.view.children
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Pair

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)

        window.exitTransition = Fade().apply {
            mode = Fade.MODE_OUT
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        window.reenterTransition = Fade().apply {
            duration = 1000
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        text_main.setOnClickListener {
            val pair  = Pair(image, "image_name")
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pair)
            startActivity(Intent(this, SecondActivity::class.java), activityOptions.toBundle())
        }
    }
}