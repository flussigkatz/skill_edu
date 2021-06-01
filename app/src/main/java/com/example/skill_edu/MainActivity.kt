package com.example.skill_edu

import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.view.Menu
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.SearchView
import timber.log.Timber
import androidx.cursoradapter.widget.SimpleCursorAdapter


class MainActivity : AppCompatActivity() {
    private val list = mutableListOf<String>()
    private lateinit var mAdapter: SimpleCursorAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifeCicleListener())
        Timber.d("onCreate")
        val from = arrayOf("items")
        val to = intArrayOf(android.R.id.text1)
        mAdapter = SimpleCursorAdapter(this,
                R.layout.item,
                null,
                from,
                to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)

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
            override fun onQueryTextChange(newText: String): Boolean {
                /*if (list.contains(newText)) {
                    tv1.text = "In list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorGreen))
                } else {
                    tv1.text = "Not in list"
                    tv1.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorRed))
                }*/

                populateAdapter(newText)
                return false
            }
        })
        searchView.suggestionsAdapter = mAdapter

        searchView.setOnSuggestionListener(object: SearchView.OnSuggestionListener{
            override fun onSuggestionSelect(position: Int): Boolean {
                return true
            }

            override fun onSuggestionClick(position: Int): Boolean {
                val cursor: Cursor = mAdapter!!.getItem(position) as Cursor
                val txt: String = cursor.getString(cursor.getColumnIndex("items"))
                searchView.setQuery(txt, false)
                searchView.clearFocus()
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun populateAdapter(query: String) {
        val c = MatrixCursor(arrayOf(BaseColumns._ID, "items"))
//        for (i in suggestions.indices)
    }


}