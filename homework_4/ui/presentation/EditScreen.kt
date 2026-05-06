package com.example.homework_4.ui.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homework_4.ui.model.EditViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditScreen(
    noteId: Int?,
    viewModel: EditViewModel,
    onBack: () -> Unit
) {
    // Lokalni state za unos teksta
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var dateText by remember { mutableStateOf("") }

    // Ako uređujemo postojeću, povuci podatke iz ViewModela
    LaunchedEffect(noteId) {
        if (noteId != null) {
            val existingNote = viewModel.getNote(noteId)
            existingNote?.let {
                title = it.title
                content = it.description
                dateText = "Datum: ${it.createdAt}"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 32.dp), // Zbog EdgeToEdge
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = if (noteId == null) "Nova bilješka" else "Uredi bilješku", fontSize = 24.sp)

        if (dateText.isNotEmpty()) {
            Text(text = dateText, fontSize = 12.sp, color = Color.Gray)
        }

        androidx.compose.material3.OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Naslov") },
            modifier = Modifier.fillMaxWidth()
        )

        androidx.compose.material3.OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Sadržaj") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 5
        )

        Button(
            onClick = {
                viewModel.saveNote(title, content, noteId)
                onBack() // Vrati se na listu nakon spremanja
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Done")
        }
    }
}