package com.example.gdg_predavanje_3.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gdg_predavanje_3.ItemCard
import com.example.gdg_predavanje_3.ui.data.MyData
import com.example.gdg_predavanje_3.ui.data.Note

@Composable
fun NoteListScreen(
    notes:List<Note>,
    onClickEdit: (Int) -> Unit
){
    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.Companion.padding(innerPadding)) {
        }
    }
}

@Composable
fun MyItemList(mojiPodaci: List<MyData>, onNavigator: (Int) -> Unit) {
    var itemsState by remember { mutableStateOf(mojiPodaci) }

    Column(modifier = Modifier.Companion.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.Companion.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(itemsState) { data ->
            }

        }
    }
}

@Composable
fun NoteCard(note:Note){
    Column {
        
    }
}