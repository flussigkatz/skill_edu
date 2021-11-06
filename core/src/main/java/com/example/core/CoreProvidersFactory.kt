package com.example.core

import com.example.core_api.AppProvider
import com.example.core_api.db.DatabaseProvider
import com.example.core_impl.DaggerDatabaseComponent

object CoreProvidersFactory {
    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }
}