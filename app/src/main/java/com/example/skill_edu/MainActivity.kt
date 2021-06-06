package com.example.skill_edu

import android.graphics.Rect
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.transition.Visibility.MODE_IN
import android.transition.Visibility.MODE_OUT
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.TableRow
import androidx.annotation.IntDef
import androidx.appcompat.app.AppCompatActivity
import androidx.core.transition.addListener
import androidx.core.view.children
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emptyAdapter = MyAdapter(0)
        adapter = MyAdapter(9) {
            val viewRect = Rect()
            it.getGlobalVisibleRect(viewRect)
            val slideIn = Slide().apply {
                mode = MODE_IN
                duration = 1000
                slideEdge = Gravity.START

//                epicenterCallback = object : Transition.EpicenterCallback() {
//                    override fun onGetEpicenter(transition: Transition?): Rect {
//                        return viewRect
//                    }
//                }

            }

            val slideOut = Slide().apply {
                mode = MODE_OUT
                duration = 1000
                slideEdge = Gravity.END
//                epicenterCallback = object : Transition.EpicenterCallback() {
//                    override fun onGetEpicenter(transition: Transition?): Rect {
//                        return viewRect
//                    }
//                }
            }

            slideOut.addListener({ _ ->
                TransitionManager.beginDelayedTransition(recycler_view, slideIn)
                recycler_view.adapter = adapter
                it.setBackgroundResource(R.color.black)
            })
            TransitionManager.beginDelayedTransition(recycler_view, slideOut)
            recycler_view.adapter = emptyAdapter
            it.setBackgroundResource(R.color.black)
        }

        recycler_view.adapter = adapter
    }
}