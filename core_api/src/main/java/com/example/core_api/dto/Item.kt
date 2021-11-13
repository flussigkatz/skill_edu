package com.example.core_api.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ITEMS")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String
)