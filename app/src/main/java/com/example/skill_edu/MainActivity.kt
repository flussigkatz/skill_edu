package com.example.skill_edu

import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scene3.*
import kotlinx.android.synthetic.main.scene4.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, this)
        val scene3 = Scene.getSceneForLayout(scene_root, R.layout.scene3, this)
        val scene4 = Scene.getSceneForLayout(scene_root, R.layout.scene4, this)
//        val transitionManager = TransitionManager()
        val transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.trans_man, scene_root)
        transitionManager.transitionTo(scene3)
        btn3.setOnClickListener {
            transitionManager.transitionTo(scene4)
        }

    }



}