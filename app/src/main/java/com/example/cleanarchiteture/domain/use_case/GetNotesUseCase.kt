package com.example.cleanarchiteture.domain.use_case

import com.example.cleanarchiteture.domain.model.Note
import com.example.cleanarchiteture.domain.repository.NoteRepository

class GetNotesUseCase(
    private val repository:NoteRepository
) {
    suspend operator fun invoke():List<Note>{
        return repository.getNotes()
    }
}