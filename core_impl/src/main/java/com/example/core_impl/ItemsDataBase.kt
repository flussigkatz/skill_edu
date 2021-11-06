package com.example.core_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_api.db.DataBaseContract
import com.example.core_api.dto.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemsDataBase : RoomDatabase(), DataBaseContract