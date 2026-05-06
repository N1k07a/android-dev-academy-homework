package com.example.homework_4.ui.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.homework_4.ui.data.Note

class EditViewModel(private val repository: NoteRepository): ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    fun saveNote(title:String, content:String, id:Int? = null){
        repository.saveNote(title,content,id)
    }

    fun getNote(id: Int): Note? = repository.getNoteById(id)
}