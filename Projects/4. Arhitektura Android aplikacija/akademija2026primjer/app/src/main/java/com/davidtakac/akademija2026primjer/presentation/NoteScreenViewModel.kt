package com.davidtakac.akademija2026primjer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.davidtakac.akademija2026primjer.model.GetNoteResult
import com.davidtakac.akademija2026primjer.model.Note
import com.davidtakac.akademija2026primjer.model.NoteRepository
import com.davidtakac.akademija2026primjer.model.SaveNoteResult
import com.davidtakac.akademija2026primjer.model.noteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteScreenViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<NoteScreenState>(NoteScreenState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getNote() {
        viewModelScope.launch {
            _uiState.value = NoteScreenState.Loading
            _uiState.value = when (val result = noteRepository.get()) {
                is GetNoteResult.Success -> NoteScreenState.Loaded(
                    content = result.note.content,
                    noteSavingState = NoteSavingState.Success,
                )

                GetNoteResult.Failure -> NoteScreenState.Error
            }
        }
    }

    fun saveNote(content: String) {
        viewModelScope.launch {
            val currentState = _uiState.value as? NoteScreenState.Loaded
                ?: throw IllegalStateException()

            _uiState.value = currentState.copy(noteSavingState = NoteSavingState.InProgress)
            _uiState.value = when (val result = noteRepository.save(Note(content))) {
                is SaveNoteResult.Success -> currentState.copy(
                    content = result.note.content,
                    noteSavingState = NoteSavingState.Success
                )

                SaveNoteResult.Failure -> currentState.copy(
                    noteSavingState = NoteSavingState.Failure("No network!")
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
                NoteScreenViewModel(noteRepository) as T
        }
    }
}
