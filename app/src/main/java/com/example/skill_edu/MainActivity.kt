package com.example.skill_edu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FirstFragment())
            .addToBackStack(null)
            .commit()

        /*button_send.setOnClickListener {
            passData(edit_text_1.text.toString())
        }*/

        button_send.setOnClickListener {
            passData(text_send.text.toString())
        }
    }

    fun passData(editext: String) {
        val bundle = Bundle()
        bundle.putString("input", editext)


        val frag2 = ReceiverFragment()
        frag2.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, frag2)
            .addToBackStack(null)
            .commit()
    }


}