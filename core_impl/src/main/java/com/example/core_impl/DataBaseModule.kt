package com.example.core_impl

import android.content.Context
import androidx.room.Room
import com.example.core_api.db.DataBaseContract
import com.example.core_api.db.ItemsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DATABASE_NAME = "ITEMS_DB"

@Module
object DataBaseModule {
    @Provides
    @Singleton
    fun provideItemsDao(dataBaseContract: DataBaseContract): ItemsDao {
        return dataBaseContract.itemsDao()
    }

    @Provides
    @Singleton
    fun provideItemsDataBase(context: Context): DataBaseContract {
        return Room.databaseBuilder(
            context,
            ItemsDataBase::class.java,
            DATABASE_NAME).build()
    }


}