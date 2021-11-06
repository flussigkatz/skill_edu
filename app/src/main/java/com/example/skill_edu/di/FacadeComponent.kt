package com.example.skill_edu.di

import android.app.Application
import com.example.core.CoreProvidersFactory
import com.example.core_api.AppProvider
import com.example.core_api.db.DatabaseProvider
import com.example.skill_edu.App
import dagger.Component

@Component(
    dependencies = [AppProvider::class, DatabaseProvider::class]
)
interface FacadeComponent {

    companion object {
        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .databaseProvider(CoreProvidersFactory.createDatabaseBuilder(AppComponent.create(application)))
                .build()
    }

    fun inject(app: App)
}