package com.example.skill_edu

import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.SearchView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val list = mutableListOf<String>()
    private lateinit var mAdapter: SimpleCursorAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)


        for (i in 1 .. 10) {
            list.add("index$i")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //"Надуваем" наше меню
        menuInflater.inflate(R.menu.search_menu, menu)
        //Находим наш пункт меню с поиском
        val menuItem = menu?.findItem(R.id.search)
        //Привязываем его как поле для поиска
        val searchView = menuItem?.actionView as SearchView
        //Задаем слушатель изменений ввода текста
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            //Здесь выполняется код по нажатию на кнопку поиска
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (list.contains(query)) {
                    tv1.text = "In list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorGreen))
                } else {
                    tv1.text = "Not in list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorRed))
                }
                return false
            }
            //Здесь выполняется код при любом изменении текста
            override fun onQueryTextChange(newText: String?): Boolean {
                /*if (list.contains(newText)) {
                    tv1.text = "In list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorGreen))
                } else {
                    tv1.text = "Not in list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorRed))
                }*/
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


}