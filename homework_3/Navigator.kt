package com.example.gdg_predavanje_3.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gdg_predavanje_3.ui.data.MyData
import com.example.gdg_predavanje_3.ui.ListScreen
import com.example.gdg_predavanje_3.ui.data.Note
import com.example.gdg_predavanje_3.ui.model.NotesRepository
import com.example.gdg_predavanje_3.ui.presentation.NoteListScreen

const val NOTE_LIST_SCREEN = "note_list_screen"
const val EDIT_SCREEN = "edit_screen"


@Composable
fun Navigator(){
    val navController = rememberNavController()

    val notesRepository: NotesRepository = NotesRepository()


    NavHost(navController, NOTE_LIST_SCREEN) {
        composable(NOTE_LIST_SCREEN) {
            NoteListScreen(notesRepository.getList(), onClickEdit = { })
        }

        composable("$EDIT_SCREEN/{itemId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
        }
    }

}