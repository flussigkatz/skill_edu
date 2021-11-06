package com.example.core_api.db

interface DatabaseProvider {
    fun itemsDao(): ItemsDao
}