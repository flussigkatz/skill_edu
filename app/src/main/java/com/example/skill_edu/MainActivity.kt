package com.example.skill_edu

import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scene3.*
import kotlinx.android.synthetic.main.scene3.view.*
import kotlinx.android.synthetic.main.scene3.view.btn3
import kotlinx.android.synthetic.main.scene4.view.*

class MainActivity : AppCompatActivity() {
    private var state = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val whdth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 420F, resources.displayMetrics).toInt()
        val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280F, resources.displayMetrics).toInt()
        val rect1 = Rect(0, 0, whdth / 2, height / 2)
        val rect2 = Rect(0, 0, whdth, height)
        img.clipBounds = rect1
        img.setOnClickListener {
            TransitionManager.beginDelayedTransition(root, ChangeClipBounds())
            img.clipBounds = if(img.clipBounds == rect1) rect2 else rect1
        }
    }


}