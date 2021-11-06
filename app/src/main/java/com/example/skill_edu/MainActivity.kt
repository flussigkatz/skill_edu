package com.example.skill_edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core_api.dto.Item
import com.example.skill_edu.databinding.ActivityMainBinding
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.instance.itemsDao.getItems().observe(this) { list ->
            binding.txt.text = list.joinToString {
                "${it.id} : ${it.title}"
            }
        }

        binding.btn.setOnClickListener {
            val text = binding.edtxt.text.toString()
            Executors.newSingleThreadExecutor().execute {
                App.instance.itemsDao.insertItem(Item(title = text))
            }
        }

    }


}