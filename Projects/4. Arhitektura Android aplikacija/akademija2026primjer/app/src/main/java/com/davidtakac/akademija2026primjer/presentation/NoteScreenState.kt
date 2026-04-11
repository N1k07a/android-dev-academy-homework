package com.davidtakac.akademija2026primjer.presentation

sealed interface NoteScreenState {
    data class Loaded(
        val content: String,
        val noteSavingState: NoteSavingState,
    ) : NoteScreenState
    data object Loading : NoteScreenState
    data object Error : NoteScreenState
}

sealed interface NoteSavingState {
    data object Success : NoteSavingState
    data class Failure(val message: String) : NoteSavingState
    data object InProgress : NoteSavingState
}
