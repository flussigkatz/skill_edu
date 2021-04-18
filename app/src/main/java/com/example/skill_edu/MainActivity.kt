package com.example.skill_edu

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            var image = ImageView(this)
            image.setImageResource(R.drawable.rocket)
//            to do image size
            container.addView(image)
        }

        del.setOnClickListener {
            if (container.childCount != 0) {
                container.removeViewAt(container.childCount -1)
                    }
        }

        /*hide.setOnClickListener {
            if (sun.alpha == 0F) {
                sun.animate()
                        .setDuration(1000)
                        .setInterpolator(DecelerateInterpolator())
                        .alpha(1f)
                        .start()

            } else {
                sun.animate()
                        .setDuration(1000)
                        .setInterpolator(DecelerateInterpolator())
                        .alpha(0f)
                        .start()
            }
        }
*/

//        val testAnim1 = ObjectAnimator.ofFloat(sun, View.SCALE_X, 1F, 2F)
//        val testAnim2 = ObjectAnimator.ofFloat(sun, View.SCALE_Y, 1F, 2F)
//        val animSet = AnimatorSet()
//        animSet.playTogether(testAnim1,testAnim2)
//        testAnim1.setDuration(3000).interpolator = BounceInterpolator()
//        testAnim2.setDuration(3000).interpolator = BounceInterpolator()
//        animSet.startDelay = 700
//        animSet.start()

        /*sun.animate()
                .translationY(-1200f)
                .setDuration(3000)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .setListener(object : Animator.AnimatorListener{
                    override fun onAnimationStart(animation: Animator?) {
                        night.animate()
                                .alpha(0f)
                                .setInterpolator(AccelerateInterpolator())
                                .setDuration(3000)
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        cloud_right.animate()
                                .translationX(-700f)
                                .setDuration(1500)
                                .setInterpolator(DecelerateInterpolator())

                        cloud_left.animate()
                                .translationX(500f)
                                .setDuration(1500)
                                .setInterpolator(DecelerateInterpolator())
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationRepeat(animation: Animator?) {
                    }

                })
*/


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