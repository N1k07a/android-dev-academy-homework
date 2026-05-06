package com.example.homework_4.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homework_4.ui.data.Note
import com.example.homework_4.ui.model.ListViewModel
import androidx.compose.foundation.lazy.items


@Composable
fun ListScreen(
    viewModel: ListViewModel,
    onNoteClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {
    val notes by viewModel.notes.collectAsState()

    // Ovo sam nasao na netu
    LaunchedEffect(Unit) {
        viewModel.loadNotes()
    }

    Scaffold(
        floatingActionButton = {
            Button(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notes) { note ->
                NoteItem(note = note, onClick = { onNoteClick(note.id) })
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = note.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = note.description, maxLines = 2, fontSize = 14.sp)
            Text(
                text = "Kreirano: ${note.createdAt}",
                fontSize = 10.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}