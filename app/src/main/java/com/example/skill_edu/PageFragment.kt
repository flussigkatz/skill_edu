package com.example.skill_edu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_page.view.*

class PageFragment(var position: Int) : Fragment() {
    val colors = arrayOf(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.WHITE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.text.text = "${position + 1}"
        view.setBackgroundColor(colors[position])
    }
}