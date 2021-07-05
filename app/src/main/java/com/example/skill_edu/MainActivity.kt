package com.example.skill_edu

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.skill_edu.databinding.ActivityMainBinding

@BindingAdapter(value = ["color1", "color2", "color3"], requireAll = true)
fun setGradientBackground(view: ImageView, color1: Int, color2: Int, color3: Int) {
    val colors = intArrayOf(
        color1, color2, color3
    )
    val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)
    gd.cornerRadius = 0f
    view.background = gd
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}