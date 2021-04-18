package com.example.skill_edu

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animatorSet = AnimatorSet()

        val sunRise = ObjectAnimator.ofFloat(sun, View.TRANSLATION_Y, -1200F)
        val cloudMove1 = ObjectAnimator.ofFloat(cloud_right, View.TRANSLATION_X, -700F)
        val cloudMove2 = ObjectAnimator.ofFloat(cloud_left, View.TRANSLATION_X, 500F)
        val lightsOn = ObjectAnimator.ofFloat(night, View.ALPHA, 1F, 0F)
        lightsOn.setDuration(3000).start()
        cloudMove1.startDelay = 2500
        cloudMove2.startDelay = 2500
        sunRise.setDuration(3000).start()
        cloudMove1.setDuration(1500).start()
        cloudMove2.setDuration(1500).start()


    }
}