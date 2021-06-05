package com.example.skill_edu

import android.os.Bundle
import android.transition.*
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var state = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scene_root = findViewById<FrameLayout>(R.id.scene_root)
        val scene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, this)
        val scene3 = Scene.getSceneForLayout(scene_root, R.layout.scene3, this)
        val scene4 = Scene.getSceneForLayout(scene_root, R.layout.scene4, this)
        val transSet = TransitionSet()
        transSet.addTransition(Fade())
        transSet.addTransition(Slide().apply { slideEdge = Gravity.TOP; duration = 300 })
        transSet.ordering = TransitionSet.ORDERING_SEQUENTIAL
//        val transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.trans_man, scene_root)
        val transitionManager = TransitionManager()
        transitionManager.transitionTo(scene1)
        scene_root.setOnClickListener {
            TransitionManager.go(scene2, transSet)
        }

    }



}