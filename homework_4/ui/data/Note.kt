package com.example.homework_4.ui.data

import android.provider.ContactsContract
import androidx.compose.material3.DatePicker
import java.sql.Date
import java.time.LocalDateTime

data class Note (
    val id:Int,
    var title:String,
    var description:String,
    val createdAt: LocalDateTime
)