package com.example.homework_4.ui.model

import androidx.lifecycle.ViewModel
import com.example.homework_4.ui.data.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListViewModel(private  val repository: NoteRepository): ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    fun loadNotes() {
        _notes.value = repository.getNotes()
    }
}