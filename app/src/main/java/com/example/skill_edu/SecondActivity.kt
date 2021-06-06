package com.example.skill_edu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import android.view.View
import android.view.Window
import androidx.core.transition.addListener
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.allowEnterTransitionOverlap = true
        window.allowReturnTransitionOverlap = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        window.enterTransition = Fade().apply {
            duration = 1000
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
            addListener(onStart = {
                val slideIn = Slide().apply {
                    mode = Slide.MODE_IN
                    slideEdge = Gravity.BOTTOM
                }
                image.visibility = View.INVISIBLE
                TransitionManager.beginDelayedTransition(second, slideIn)
                image.visibility = View.VISIBLE
            })
        }
        window.returnTransition = TransitionSet().apply {
            addTransition(Slide(Gravity.BOTTOM).apply {
                mode = Slide.MODE_OUT
                addTarget(image)
                removeTarget(second)
            })
            addTransition(Slide(Gravity.END).apply {
                mode = Slide.MODE_OUT
                excludeTarget(android.R.id.statusBarBackground, true)
                excludeTarget(android.R.id.navigationBarBackground, true)
            })
            ordering = TransitionSet.ORDERING_TOGETHER
        }
    }
}