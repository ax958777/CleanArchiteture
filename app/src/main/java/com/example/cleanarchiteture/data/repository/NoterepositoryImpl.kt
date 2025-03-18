package com.example.cleanarchiteture.data.repository

import com.example.cleanarchiteture.data.local.NoteDao
import com.example.cleanarchiteture.data.local.NoteEntity
import com.example.cleanarchiteture.domain.model.Note
import com.example.cleanarchiteture.domain.repository.NoteRepository

class NoterepositoryImpl(
    private val dao:NoteDao
) :NoteRepository{
    override suspend fun getNotes(): List<Note> {
        return dao.getNotes().map{ entity ->
            mapNoteEntityToNote(entity)
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    private fun mapNoteEntityToNote(entity:NoteEntity):Note{
        return Note(
            id=entity.id,
            title = entity.title,
            content = entity.content,
            timestamp = entity.timestamp
        )
    }
}