package com.example.gdg_predavanje_3.ui.model

import com.example.gdg_predavanje_3.ui.data.Note

val notesRepository by lazy{
    NotesRepository()
}

class NotesRepository{
    private val notes = mutableListOf<Note>()
    fun getList() : List<Note>{
        return notes
    }

    fun addNote(note: Note){
        val index = notes.lastIndex + 1
        notes[index] = note
    }
}