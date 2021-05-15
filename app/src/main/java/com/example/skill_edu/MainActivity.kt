package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import com.example.skill_edu.App

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        val tag = "fragment_1"
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fargment_container, FirstFragment(), tag)
            .addToBackStack(null)
            .commit()
    }

    fun passData(edittext: String) {
        val bundle = Bundle()
        bundle.putString("input", edittext)

        val fragment2 = FirstFragment()
        fragment2.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fargment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}