package com.example.cleanarchiteture.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    suspend fun getNotes():List<NoteEntity>
}