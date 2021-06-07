package com.example.skill_edu

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity

class MainFragment : Fragment() {
    init {
        val d = 800L
        exitTransition = Slide(Gravity.START).apply {
            duration = d
            mode = Slide.MODE_OUT
        }
        reenterTransition = Slide(Gravity.START).apply { duration = d }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.setOnClickListener{
            val a = activity as FragmentActivity
            a.supportFragmentManager.beginTransaction()
                .replace(R.id.contaiber, SecondFragment())
                .addToBackStack("MainFragment")
                .commit()
        }
    }

}