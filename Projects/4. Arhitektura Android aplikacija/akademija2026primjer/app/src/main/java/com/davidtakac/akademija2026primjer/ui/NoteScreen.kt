package com.davidtakac.akademija2026primjer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.davidtakac.akademija2026primjer.presentation.NoteSavingState
import com.davidtakac.akademija2026primjer.presentation.NoteScreenState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    state: NoteScreenState.Loaded,
    onSaveClick: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text("My Note")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
        ) {
            var content by remember { mutableStateOf(state.content) }
            var editing by remember { mutableStateOf(false) }
            LaunchedEffect(state.noteSavingState) {
                if (state.noteSavingState == NoteSavingState.Success) {
                    editing = false
                }
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = content,
                onValueChange = { content = it },
                readOnly = !editing,
                supportingText = {
                    (state.noteSavingState as? NoteSavingState.Failure)?.let {
                        Text(it.message)
                    }
                },
                minLines = 5,
            )

            if (editing) {
                SaveButton(
                    onClick = { onSaveClick(content) },
                    saving = state.noteSavingState is NoteSavingState.InProgress
                )
            } else {
                EditButton(onClick = { editing = true })
            }
        }
    }
}
