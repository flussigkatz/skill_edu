package com.example.skill_edu

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.m21.*

class M21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m21)

        val button2 = Button(ContextThemeWrapper(this, R.style.buttonStyle))
        button2.text = "Button2"
        container.addView(button2)

//        val textView = TextView(ContextThemeWrapper(this, R.style.textStyle))
//        textView.text = "TEtx"
//        container.addView(textView)


        topPanel.setNavigationOnClickListener {
            Toast.makeText(this, "Nav", Toast.LENGTH_SHORT).show()
        }

        topPanel.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.first_action -> {
                    Toast.makeText(this, "First", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.second_action -> {
                    Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.third_action -> {
                    Toast.makeText(this, "Third", Toast.LENGTH_SHORT).show()
                    true
                } else -> false
            }
        }
        /*topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Когда-нибудь здесь будет навигация...", Toast.LENGTH_SHORT).show()
        }
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.fav -> {Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
                true
                }
                R.id.search -> {Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                true
                }
                R.id.more -> {Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                true
                }
                else -> false
            }
        }*/
    }


}