package com.example.cloneyoutube.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cloneyoutube.data.db.entities.InitialEntity

@Dao
interface InitialDao {
    @Query("select * from tbInit")
    suspend fun getAll():List<InitialEntity>
}