package com.example.gdg_predavanje_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.gdg_predavanje_3.ui.ListScreen
import com.example.gdg_predavanje_3.ui.data.MyData
import com.example.gdg_predavanje_3.ui.Navigator
import com.example.gdg_predavanje_3.ui.theme.Gdg_predavanje_3Theme
import org.jetbrains.annotations.Async

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var data = MyData(1,"At the Mountains Of Madness", "A really interesanting book that pick your brain about what " +
                "kind of hideous thing could exist in this huge and unexplored ...")


        setContent {
            Gdg_predavanje_3Theme {
                Navigator()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gdg_predavanje_3Theme {
        Greeting("Android")
    }
}

@Composable
fun TitleText(title: String){
    Text(
        text = title,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun DescriptionText(text: String){
    Text(
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        maxLines = 3
    )
}


@Composable
fun ItemCard(data: MyData, imageURL: String, onNavigate:(Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(16.dp)) {
                TitleText(data.title)
                DescriptionText(data.description)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {}) { Text("Save") }
                    Button(onClick = {onNavigate(data.ID)}) { Text("Det") }
                }
            }

            AsyncImage(
                model = imageURL,
                contentDescription = "Slika za knjigu",
                modifier = Modifier
                    .size(200.dp)
                    .weight(1f)
                    .wrapContentWidth(Alignment.End),
            )
        }
    }
}

