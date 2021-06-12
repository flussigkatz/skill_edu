package com.example.skill_edu

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.drawable.AnimatedVectorDrawable
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
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.hypot
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottieAnimationView: LottieAnimationView = lonim2
        lottieAnimationView.repeatMode = LottieDrawable.RESTART
        lottieAnimationView.playAnimation()

    }


}