package com.example.skill_edu

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SecondFragment : Fragment() {
    init {
        val d = 800L
        enterTransition = Slide(Gravity.END).apply {
            duration = d
        }
        returnTransition = Slide(Gravity.END).apply {
            duration = d
            mode = Slide.MODE_OUT
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

}