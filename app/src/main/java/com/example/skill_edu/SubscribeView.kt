package com.example.skill_edu

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.Nullable
import kotlinx.android.synthetic.main.subscribe.view.*

class SubscribeView (context: Context, @Nullable attributeSet: AttributeSet): LinearLayout(context, attributeSet) {
    private val editText: EditText
    private val subscribeButton: Button

    init {
        LayoutInflater.from(context).inflate(R.layout.subscribe, this)
        this.orientation = VERTICAL
        editText = et_sub
        subscribeButton  = btn_sub

        subscribeButton.setOnClickListener {
            Toast.makeText(context, editText.text, Toast.LENGTH_SHORT).show()
        }
    }


}