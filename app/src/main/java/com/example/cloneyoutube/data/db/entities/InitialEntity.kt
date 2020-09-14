package com.example.cloneyoutube.data.db.entities

import androidx.room.Entity

@Entity(tableName = "tbInit", primaryKeys = ["id"])
data class InitialEntity(val id: String, val username: String) {
}