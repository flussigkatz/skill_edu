package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))
        val main = findViewById<CoordinatorLayout>(R.id.main)
        val snackbar = Snackbar.make(main, "Hello", Snackbar.LENGTH_SHORT)
        snackbar.setAction("Acction") {
            Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
        }
        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.design_default_color_error))
        val appBar = findViewById<AppBarLayout>(R.id.app_bar)
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset == 0) {
                findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).setExpandedTitleColor(
                    ContextCompat.getColor(this, R.color.design_default_color_error)
                )
            }
            if (Math.abs(verticalOffset) >= appBarLayout.scrollBarSize) {
                findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).setCollapsedTitleTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.teal_200
                    )
                )
            }
        })
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                R.id.action_two -> Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show()
                R.id.action_third -> Toast.makeText(this, "Tree", Toast.LENGTH_SHORT).show()
            }
            false
        }
        val bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet))
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
//            snackbar.show()
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(bottomSheetBehavior.state) {
                    1 -> findViewById<TextView>(R.id.label).text = "STATE DRAGGING"
                    2 -> findViewById<TextView>(R.id.label).text = "STATE SETTLING"
                    3 -> findViewById<TextView>(R.id.label).text = "STATE EXPANDED"
                    4 -> findViewById<TextView>(R.id.label).text = "STATE COLLAPSED"
                    5 -> findViewById<TextView>(R.id.label).text = "STATE HIDDEN"
                    6 -> findViewById<TextView>(R.id.label).text = "STATE HALF EXPANDED"
                }
                findViewById<TextView>(R.id.label).text
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                fab.scaleX = 1 - slideOffset
                fab.scaleY = 1 - slideOffset
                findViewById<FrameLayout>(R.id.tint_back).alpha = (slideOffset/1.2f)
            }

        })
    }
}