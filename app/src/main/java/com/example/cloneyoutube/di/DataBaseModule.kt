package com.example.cloneyoutube.di

import android.content.Context
import androidx.room.Room
import com.example.cloneyoutube.data.AppDatabase
import com.example.cloneyoutube.utils.Constants
import org.koin.dsl.module

val databaseModule = module {

//inject Database
    single { createAppDatabase(get()) }

//inject Dao
    single { createDao(get()) }
}

fun createDao(appDatabase: AppDatabase) = appDatabase.initialDao()

fun createAppDatabase(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()
