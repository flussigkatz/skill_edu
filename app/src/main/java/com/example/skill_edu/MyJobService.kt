package com.example.skill_edu

import android.app.job.JobParameters
import android.app.job.JobService

class MyJobService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        println("START")
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        println("STOP")
        return false
    }

}