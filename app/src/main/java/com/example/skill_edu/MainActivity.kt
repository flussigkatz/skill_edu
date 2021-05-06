package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

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
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            snackbar.show()
        }
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
        /*val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                R.id.action_two -> Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show()
                R.id.action_third -> Toast.makeText(this, "Tree", Toast.LENGTH_SHORT).show()
            }
            false
        }*/
    }
}