package com.example.skill_edu

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first()
        second()

    }

    fun first() {
        val fileName = "MyFile"
        val content = "Content1"
        this.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(content.toByteArray())
        }
    }

    fun second() {
        val fileTempName = "file_name"
        File.createTempFile(fileTempName, null, this.cacheDir)
        val tempFiles = this.cacheDir.listFiles()
        val tempFile = tempFiles[tempFiles.lastIndex]
        val content = "tempContent!"
        tempFile.writeText(content)
        tempFile.bufferedReader()?.useLines {
            var result = ""
            it.forEach { result += it }
            println(result)
        }
//        val list = this.fileList()
//        this.deleteFile(list[list.lastIndex])

    }

    fun clearCache() {
        this.cacheDir.listFiles()?.forEach { File(this.cacheDir, it.name).delete() }

    }

    fun clearFiles() {
//        val file = File(this.filesDir, name)
//        file.delete()

        this.fileList().forEach { deleteFile(it) }
    }

    override fun onDestroy() {
        super.onDestroy()

        clearCache()
        clearFiles()



    }


}