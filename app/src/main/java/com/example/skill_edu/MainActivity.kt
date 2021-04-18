package com.example.skill_edu

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val testAnim1 = ObjectAnimator.ofFloat(sun, View.SCALE_X, 1F, 2F)
        val testAnim2 = ObjectAnimator.ofFloat(sun, View.SCALE_Y, 1F, 2F)
        val animSet = AnimatorSet()
        animSet.playTogether(testAnim1,testAnim2)
        testAnim1.setDuration(3000).interpolator = BounceInterpolator()
        testAnim2.setDuration(3000).interpolator = BounceInterpolator()
        animSet.startDelay = 700
        animSet.start()

        /*val sunRise = ObjectAnimator.ofFloat(sun, View.TRANSLATION_Y, -1200F)
        val cloudMove1 = ObjectAnimator.ofFloat(cloud_right, View.TRANSLATION_X, -700F)
        val cloudMove2 = ObjectAnimator.ofFloat(cloud_left, View.TRANSLATION_X, 500F)
        val lightsOn = ObjectAnimator.ofFloat(night, View.ALPHA, 1F, 0F)
        lightsOn.interpolator = AccelerateDecelerateInterpolator()
        lightsOn.setDuration(3000).start()
        cloudMove1.startDelay = 2500
        cloudMove2.startDelay = 2500
        cloudMove1.interpolator = AccelerateDecelerateInterpolator()
        cloudMove2.interpolator = AccelerateDecelerateInterpolator()
        sunRise.interpolator = AccelerateDecelerateInterpolator()
        sunRise.setDuration(3000).start()
        cloudMove1.setDuration(1500).start()
        cloudMove2.setDuration(1500).start()*/


    }
}