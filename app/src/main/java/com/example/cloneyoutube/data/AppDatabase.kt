package com.example.cloneyoutube.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cloneyoutube.data.db.dao.InitialDao
import com.example.cloneyoutube.data.db.entities.InitialEntity

@Database(entities = [InitialEntity::class],  version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun initialDao():InitialDao
}