package com.example.skill_edu

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.work.*
import com.example.skill_edu.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.concurrent.TimeUnit
import kotlin.coroutines.EmptyCoroutineContext

var mBitmap: Bitmap? = null


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cBitmap: Bitmap? = null

        val uri = "https://images.pexels.com/photos/3943198/pexels-photo-3943198.jpeg"

        val target = object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                cBitmap = bitmap
                binding.image.setImageBitmap(bitmap)
                println("load")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                println("fail")
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }
        }
            Picasso.get().load(uri).into(target)

//        val component = ComponentName(this, MyJobService::class.java)
//        val jobInfo = JobInfo.Builder(1, component)
//                .setMinimumLatency(1000)
//                .setOverrideDeadline(5000)
//                .setRequiresCharging(false)
//                .build()
//
//        val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
//
//        val res = jobScheduler.schedule(jobInfo)
//
//        if (res == JobScheduler.RESULT_SUCCESS) println("SCHEDULED")
//        else println("NOT SCHEDULED")


//        val workRequest = OneTimeWorkRequestBuilder<SomeWork>().build()
//        val workRequest = OneTimeWorkRequest.from(SomeWork::class.java)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .build()
        val data = workDataOf(
            "key1" to "https://images.pexels.com/photos/3943198/pexels-photo-3943198.jpeg"
        )
        val workRequest = PeriodicWorkRequestBuilder<SomeWork>(1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .setInputData(data)
            .setBackoffCriteria(
                BackoffPolicy.EXPONENTIAL, 10, TimeUnit.SECONDS
            )
            .build()

        WorkManager.getInstance(applicationContext).enqueue(workRequest)

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                println(mBitmap)
                println(cBitmap)
                delay(5000)
                if (mBitmap != null) {
                    println("Set")
                    withContext(Dispatchers.Main) {
                            binding.image.setImageBitmap(mBitmap)
                    }
                }
            }
        }


    }



}

class SomeWork(appcontext: Context, private val workerParameters: WorkerParameters) : Worker(
    appcontext, workerParameters
) {
    override fun doWork(): Result {
//        println("doWork ${(0 .. 100).random()}")
//        val uri = workerParameters.inputData.getString("key1")
//
//        println("doWork ${uri}")
//        val target = object : Target {
//            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                mBitmap = bitmap
//                println("load")
//            }
//
//            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//                println("fail")
//            }
//
//            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//            }
//        }
//            CoroutineScope(Dispatchers.Main).launch {
//                println("Picasso")
//                Picasso.get().load(uri).into(target)
//            }
        return Result.success()
    }
}