package com.example.skill_edu

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.transition.*
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.view.ViewAnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flingX = FlingAnimation(fab, DynamicAnimation.X).apply { friction = 0.005f }
        val flingY = FlingAnimation(fab, DynamicAnimation.Y).apply { friction = 0.005f }

        val gestureListener = object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent?,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                flingX.setStartVelocity(velocityX)
                flingY.setStartVelocity(velocityY)

                flingX.start()
                flingY.start()

                return true
            }
        }

        val gestureDetector = GestureDetector(this, gestureListener)

        fab.setOnTouchListener{v, event ->
            v.performClick()
            gestureDetector.onTouchEvent(event)
        }


    }


}