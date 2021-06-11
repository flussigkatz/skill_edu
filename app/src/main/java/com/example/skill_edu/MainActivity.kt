package com.example.skill_edu

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.View.*
import android.view.ViewAnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private var isRevealed = false

    private val animDuration = 30000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { reveal() }


    }

    private fun reveal() {
        val x: Int = fab.x.roundToInt() + fab.width / 2
        val y: Int = fab.y.roundToInt() + fab.height / 2
        val startRadius = 0
        val endRadius = hypot(main_container.width.toDouble(), main_container.height.toDouble())

        if (isRevealed) {
            val reverseAnim = ViewAnimationUtils.createCircularReveal(
                button_container,
                x,
                y,
                endRadius.toFloat(),
                startRadius.toFloat()
            )
            reverseAnim.duration = animDuration
            reverseAnim.interpolator = LinearInterpolator()
            reverseAnim.start()
            reverseAnim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    button_container.visibility = GONE
                }
            })
        } else {
            val anim = ViewAnimationUtils.createCircularReveal(
                button_container,
                x,
                y,
                startRadius.toFloat(),
                endRadius.toFloat()
            )
            anim.duration = animDuration
            anim.interpolator = LinearInterpolator()
            button_container.visibility = VISIBLE
            anim.start()
        }
        isRevealed = !isRevealed

    }

}