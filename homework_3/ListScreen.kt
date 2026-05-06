package com.example.gdg_predavanje_3.ui

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

@Composable
fun ListScreen(onNavigator:(Int) -> Unit){
    val mojiPodaci = listOf(
        MyData(1, "At the Mountains Of Madness", "A hideous thing could exist..."),
        MyData(2, "The Call of Cthulhu", "Dead Cthulhu waits dreaming..."),
        MyData(3, "The Shadow over Innsmouth", "Something is wrong with the harbor..."),
        MyData(4, "The Colour Out of Space", "A West of Arkham the hills rise wild..."),
        MyData(5, "The Dunwich Horror", "No one, even in Southwick, liked him...")
    )

    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.Companion.padding(innerPadding)) {
            MyItemList(mojiPodaci = mojiPodaci, onNavigator)
        }
    }
}

@Composable
fun MyItemList(mojiPodaci: List<MyData>, onNavigator: (Int) -> Unit) {
    var itemsState by remember { mutableStateOf(mojiPodaci) }

    Column(modifier = Modifier.Companion.fillMaxSize()) {
        Button(
            onClick = { itemsState = itemsState.shuffled() },
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Izmiješaj listu")
        }

        LazyColumn(
            modifier = Modifier.Companion.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(itemsState) { data ->
                ItemCard(
                    data,
                    "https://m.media-amazon.com/images/I/A1UnHUPci9L._UF1000,1000_QL80_.jpg",
                    onNavigate = onNavigator
                )
            }

        }
    }
}