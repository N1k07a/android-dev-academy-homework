package com.davidtakac.akademija2026primjer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.davidtakac.akademija2026primjer.ui.NoteErrorScreen
import com.davidtakac.akademija2026primjer.ui.NoteLoadingScreen
import com.davidtakac.akademija2026primjer.presentation.NoteScreenState
import com.davidtakac.akademija2026primjer.ui.NoteScreen
import com.davidtakac.akademija2026primjer.presentation.NoteScreenViewModel
import com.davidtakac.akademija2026primjer.ui.theme.OneNote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OneNote {
                val viewModel by viewModels<NoteScreenViewModel> { NoteScreenViewModel.Factory }
                LaunchedEffect(Unit) { viewModel.getNote() }

                when (val state = viewModel.uiState.collectAsStateWithLifecycle().value) {
                    is NoteScreenState.Loaded -> NoteScreen(
                        state = state,
                        onSaveClick = viewModel::saveNote
                    )
                    NoteScreenState.Loading -> NoteLoadingScreen()
                    NoteScreenState.Error -> NoteErrorScreen(
                        onRetryClick = viewModel::getNote
                    )
                }
            }
        }
    }
}
