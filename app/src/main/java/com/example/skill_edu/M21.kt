package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.m21.*

class M21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m21)

        topAppBar.setNavigationOnClickListener {
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
        }
    }


}