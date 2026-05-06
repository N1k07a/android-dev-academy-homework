package com.example.homework_4.ui.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.homework_4.ui.data.Note
import java.time.LocalDateTime

object NoteRepository {
    private val notes = mutableListOf<Note>()
    private var nextId = 1

    fun getNotes() : List<Note> = notes.toList()

    fun getNoteById(id:Int): Note? = notes.find { it.id == id }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveNote(title:String, content:String, id:Int? = null ){
        if (id == null) {
            notes.add(Note(id = nextId++, title = title, description = content, LocalDateTime.now()))
        } else {
            val index = notes.indexOfFirst { it.id == id }
            if (index != -1) {
                notes[index] = notes[index].copy(title = title, description = content)
            }
        }
    }
}