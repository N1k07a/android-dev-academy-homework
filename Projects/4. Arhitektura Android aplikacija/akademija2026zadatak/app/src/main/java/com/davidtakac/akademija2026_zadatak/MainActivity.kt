package com.davidtakac.akademija2026_zadatak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.davidtakac.akademija2026_zadatak.presentation.ShoppingListUiState
import com.davidtakac.akademija2026_zadatak.presentation.ShoppingListViewModel
import com.davidtakac.akademija2026_zadatak.ui.ErrorScreen
import com.davidtakac.akademija2026_zadatak.ui.LoadingScreen
import com.davidtakac.akademija2026_zadatak.ui.ShoppingListScreen
import com.davidtakac.akademija2026_zadatak.ui.theme.Akademija2026_ZadatakTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Akademija2026_ZadatakTheme {
                val viewModel by viewModels<ShoppingListViewModel> { ShoppingListViewModel.Factory }
                LaunchedEffect(Unit) { viewModel.getList() }

                when (val state = viewModel.uiState.collectAsStateWithLifecycle().value) {
                    is ShoppingListUiState.Loaded -> ShoppingListScreen(
                        state = state,
                        onCompletedToggle = viewModel::toggle
                    )
                    is ShoppingListUiState.Failure -> ErrorScreen(
                        message = state.message,
                        onRetryClick = viewModel::getList
                    )
                    ShoppingListUiState.Loading -> LoadingScreen()
                }
            }
        }
    }
}
