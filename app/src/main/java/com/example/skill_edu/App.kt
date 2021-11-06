package com.example.skill_edu

import android.app.Application
import com.example.core_api.db.ItemsDao
import com.example.skill_edu.di.FacadeComponent
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var itemsDao: ItemsDao

    override fun onCreate() {
        super.onCreate()
        instance = this
        getFacade().inject(this)
        println(itemsDao)
        println(instance)

    }

    private fun getFacade(): FacadeComponent {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    companion object {
        lateinit var instance: App
            private set
        private var facadeComponent: FacadeComponent? = null
    }
}