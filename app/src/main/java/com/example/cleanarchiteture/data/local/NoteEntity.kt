package com.example.cleanarchiteture.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val content:String,
    val timestamp:Long
)