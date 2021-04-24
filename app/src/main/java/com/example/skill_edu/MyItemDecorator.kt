package com.example.skill_edu

import android.graphics.Canvas
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class MyItemDecorator : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.children.forEachIndexed { index, view ->
            if ((index + 1) % 2 == 0) {
                view.setBackgroundResource(R.color.purple_200)
            } else {
                view.setBackgroundResource(R.color.teal_200)
            }
        }
    }
}