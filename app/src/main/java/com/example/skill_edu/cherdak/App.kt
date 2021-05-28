package com.example.skill_edu.cherdak

import android.app.Application
import com.example.skill_edu.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(DebugTree())
        }
    }
}