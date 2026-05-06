package com.example.gdg_predavanje_3.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.gdg_predavanje_3.DescriptionText
import com.example.gdg_predavanje_3.TitleText
import com.example.gdg_predavanje_3.ui.data.MyData

@Composable
fun DetailScreen(book: MyData?, onBack: () -> Unit){
    Scaffold(modifier = Modifier.fillMaxSize() ){innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            if (book != null){
                TitleText(book.title)
                DescriptionText(book.description)
            }else{
                Text("Nema podatka")
            }
            Button(onClick = {onBack()}) {
                Text("Back")
            }
        }
    }
}



