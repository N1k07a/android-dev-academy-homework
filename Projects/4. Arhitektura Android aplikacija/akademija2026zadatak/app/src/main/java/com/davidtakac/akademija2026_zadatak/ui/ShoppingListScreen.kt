package com.davidtakac.akademija2026_zadatak.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.davidtakac.akademija2026_zadatak.model.ShoppingListItem
import com.davidtakac.akademija2026_zadatak.presentation.ShoppingListUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    state: ShoppingListUiState.Loaded,
    onCompletedToggle: (ShoppingListItem) -> Unit
) {
    Scaffold(
        topBar = { MediumTopAppBar(title = { Text("Shopping List") }) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.toggling) LinearProgressIndicator(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter))
            LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
                items(state.list) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clickable(enabled = !state.toggling) { onCompletedToggle(it) }
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(it.name, modifier = Modifier.weight(1f))
                        Checkbox(checked = it.completed, onCheckedChange = null)
                    }
                }
            }
        }
    }
}
