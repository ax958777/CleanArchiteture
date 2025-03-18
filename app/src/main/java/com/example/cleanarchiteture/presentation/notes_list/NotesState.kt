package com.example.cleanarchiteture.presentation.notes_list

import com.example.cleanarchiteture.domain.model.Note

data class NotesState (
    val notes:List<Note> = emptyList(),
    val isLoading:Boolean=false,
    val error:String?=null
    )