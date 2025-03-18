package com.example.cleanarchiteture.presentation.notes_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchiteture.domain.use_case.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase
):ViewModel(){
    private val _state= MutableStateFlow(NotesState())
    val state : StateFlow<NotesState> = _state

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoading = true
            )
            try {
                val notes = getNotesUseCase()
                _state.value = state.value.copy(
                    notes = notes,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}