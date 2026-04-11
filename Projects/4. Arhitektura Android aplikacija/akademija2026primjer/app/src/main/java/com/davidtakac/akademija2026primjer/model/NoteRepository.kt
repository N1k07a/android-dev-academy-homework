package com.davidtakac.akademija2026primjer.model

import com.davidtakac.akademija2026primjer.data.NoteLocalStorage
import com.davidtakac.akademija2026primjer.data.NoteRemoteStorage

val noteRepository by lazy {
    NoteRepository(
        localStorage = NoteLocalStorage(),
        remoteStorage = NoteRemoteStorage(),
    )
}

class NoteRepository(
    private val localStorage: NoteLocalStorage,
    private val remoteStorage: NoteRemoteStorage
) {
    suspend fun save(note: Note): SaveNoteResult {
        try {
            remoteStorage.save(note)
        } catch (_: Exception) {
            return SaveNoteResult.Failure
        }

        localStorage.save(note)
        return SaveNoteResult.Success(note)
    }

    suspend fun get(): GetNoteResult {
        localStorage.get()?.let { return GetNoteResult.Success(it) }

        val remoteNote = try {
            remoteStorage.get()
        } catch (_: Exception) {
            return GetNoteResult.Failure
        }

        localStorage.save(remoteNote)
        return GetNoteResult.Success(remoteNote)
    }
}

sealed interface SaveNoteResult {
    data class Success(val note: Note) : SaveNoteResult
    data object Failure : SaveNoteResult
}

sealed interface GetNoteResult {
    data class Success(val note: Note) : GetNoteResult
    data object Failure : GetNoteResult
}
