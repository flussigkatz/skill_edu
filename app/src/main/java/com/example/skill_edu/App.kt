package com.example.skill_edu

import android.app.Application
import com.example.core_api.db.ItemsDao
import com.example.skill_edu.di.FacadeComponent
import javax.inject.Inject

class App : Application() {
    //Инжектим доступ к БД
    @Inject
    lateinit var itemsDao: ItemsDao

    override fun onCreate() {
        super.onCreate()
        instance = this
        getFacade().inject(this)
    }

    private fun getFacade(): FacadeComponent {
        //Создаем компонент
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    companion object {
        //Ссылка для доступа к itemsDao из активити
        lateinit var instance: App
            private set
        private var facadeComponent: FacadeComponent? = null
    }
}