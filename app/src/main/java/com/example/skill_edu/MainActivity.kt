package com.example.skill_edu

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import java.io.*

class MainActivity : AppCompatActivity() {
    val extenalState = Environment.getExternalStorageState()

    @SuppressLint("WrongThread")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (extenalState == Environment.MEDIA_MOUNTED) {
            val storageManager = applicationContext.getSystemService<StorageManager>()!!
            val uuid = storageManager.getUuidForPath(filesDir)
            val needSpace = 1024 * 1024 * 1L
            val availableStorage = storageManager.getAllocatableBytes(uuid)

            if (availableStorage > needSpace) {
                val fileName = "FileName"
                val content = "Content"
                val file = File(getExtFileDir(), fileName)
                BufferedWriter(FileWriter(file)).use { it.write(content) }

                BufferedReader(FileReader(file)).useLines { it.forEach { println(it) } }
            }
        }
    }

    fun getExtFileDir(): File? {
        if (extenalState == Environment.MEDIA_MOUNTED) {
            return this.getExternalFilesDir(null)
        } else {
            println("Mount external storage please.")
        }
        return null

    }


}