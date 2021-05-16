package com.example.skill_edu

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    override fun onBackPressed() {
        /*AlertDialog.Builder(ContextThemeWrapper(this, R.style.ExitDialog))
            .setTitle("Sure?")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setPositiveButton("Yes"){
                _, _ -> finish()
            }
            .setNegativeButton("No"){
                _, _ ->
            }
            .setNeutralButton("Not sure") {
                _, _ ->
                Toast.makeText(this, "Ok, later.", Toast.LENGTH_SHORT).show()
            }
            .show()*/


        DialogFragment1().show(supportFragmentManager, "dialog1")

    }


}