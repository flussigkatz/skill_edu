package com.example.skill_edu

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.squareup.picasso.Picasso
import kotlin.random.Random

class SomeWork(appcontext: Context, private val workerParameters: WorkerParameters) : Worker(
    appcontext, workerParameters
) {
    override fun doWork(): Result {
        println("doWork ${(0 .. 100).random()}")
        val uri = workerParameters.inputData.getString("key1")
//        Picasso.get().load()
        return Result.retry()
    }
}