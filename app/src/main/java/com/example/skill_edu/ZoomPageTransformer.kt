package com.example.skill_edu

import android.view.View
import androidx.viewpager.widget.ViewPager
import java.lang.Math.abs

const val MIN_SCALE = 0.85f
const val MIN_ALPHA = 0.5f



class ZoomPageTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> alpha = 0f
                position <= 1 -> {
                    val scaleFactor = MIN_SCALE.coerceAtLeast(1 - abs(position))
                    val yMargin = pageHeight * (1 -scaleFactor) / 2
                    val xMargin = pageWidth * (1- scaleFactor) / 2
                    translationX = if (position < 0) {
                        xMargin - yMargin / 2
                    } else {
                        xMargin + yMargin / 2
                    }
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    alpha = (MIN_ALPHA + (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))

                }
                else -> alpha = 0f
            }
        }
    }
}