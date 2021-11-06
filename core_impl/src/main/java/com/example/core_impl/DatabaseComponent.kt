package com.example.core_impl

import com.example.core_api.AppProvider
import com.example.core_api.db.DatabaseProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [AppProvider::class], modules = [DataBaseModule::class])
interface DatabaseComponent : DatabaseProvider