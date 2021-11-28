package com.example.skill_edu

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.skill_edu.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.coroutines.*
import java.lang.Exception
import java.util.concurrent.TimeUnit

var mBitmap: Bitmap? = null


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uri = "https://images.pexels.com/photos/3943198/pexels-photo-3943198.jpeg"
        val uri2 = "https://lms.skillfactory.ru/assets/courseware/v1/3d4135e2ab1e11084eb82d7201bb9c8b/asset-v1:SkillFactory+ANDROID-NEW+2020+type@asset+block/andr_52.5_1.png"


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
            .setRequiredNetworkType(NetworkType.METERED)
            .setRequiresBatteryNotLow(true)
            .build()
        val data = workDataOf(
            "key1" to uri2
        )
        val workRequest = PeriodicWorkRequestBuilder<SomeWork2>(1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .setInputData(data)
            .setBackoffCriteria(
                BackoffPolicy.EXPONENTIAL, 10, TimeUnit.SECONDS
            )
            .build()

        WorkManager.getInstance(applicationContext).enqueue(workRequest)

        CoroutineScope(Dispatchers.IO).launch {
            do {
                println("!!!" + mBitmap)
                delay(5000)
                if (mBitmap != null) {
                    withContext(Dispatchers.Main){
                        binding.image.setImageBitmap(mBitmap)
                    }
                }
            } while (mBitmap != null)
        }


    }



}

class SomeWork2(appContext: Context, private val workerParameters: WorkerParameters) : Worker(
    appContext, workerParameters
) {
    override fun doWork(): Result {
        println("doWork ${(0 .. 100).random()}")
        val uri = workerParameters.inputData.getString("key1")

        println("doWork ${uri}")
        val target = object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                mBitmap = bitmap
                println("load")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                println("fail")
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }
        }
            CoroutineScope(Dispatchers.Main).launch {
                println("Picasso")
                Picasso.get().load(uri).into(target)
            }
        return Result.success()
    }
}