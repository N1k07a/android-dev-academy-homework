package com.example.homework_4.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.homework_4.ui.model.EditViewModel
import com.example.homework_4.ui.model.ListViewModel
import com.example.homework_4.ui.model.NoteRepository
import com.example.homework_4.ui.presentation.EditScreen
import com.example.homework_4.ui.presentation.ListScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigator() {
    val navController = rememberNavController()

    // Budući da je NoteRepository 'object', ViewModeli ga vide sami
    // pa ne trebamo Factory ni parametre ovdje
    val listViewModel: ListViewModel = viewModel()
    val editViewModel: EditViewModel = viewModel()

    NavHost(navController = navController, startDestination = "list") {

        // Ekran s listom svih bilješki
        composable("list") {
            ListScreen(
                viewModel = listViewModel,
                onNoteClick = { id ->
                    navController.navigate("edit/$id")
                },
                onAddClick = {
                    navController.navigate("edit/-1")
                }
            )
        }

        // Ekran za dodavanje/uređivanje bilješke
        composable(
            route = "edit/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("noteId")

            // Ako je ID -1, smatramo da je to nova bilješka (null)
            val finalId = if (id == -1) null else id

            EditScreen(
                noteId = finalId,
                viewModel = editViewModel,
                onBack = {
                    listViewModel.loadNotes()
                    navController.popBackStack()
                }
            )
        }
    }
}

