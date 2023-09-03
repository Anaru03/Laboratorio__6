package com.uvg.laboratorio__6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio__6.ui.theme.Laboratorio__6Theme

// Referencias de https://github.com/android/compose-samples/tree/main
// Referencias de https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?hl=es-419#3
class ScreenGaleria : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio__6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryScreen()
                }
            }
        }
    }
}

data class ArtSpace(val title1: String, val subtitle: String,  val author: String, val year: String, val imageResId: Int)



@Composable
fun ImageCard(image: Painter, title: String, subtitle: String, author: String, year: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.art1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = subtitle, fontWeight = FontWeight.Bold, fontSize = 10.sp)
            Text(text = "Artista: $author")
            Text(text = "Año: $year")
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GalleryScreen() {
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    val galleryImages = listOf(
        ArtSpace("art1", "Image 1", "Artist 1", "2022", R.drawable.art1),
        ArtSpace("art1", "Image 2", "Artist 2", "2021", R.drawable.art2),
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art3),
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art4),
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art5), //problemas con la imagen
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art1), //problemas con la imagen
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art7),
        ArtSpace("art1", "Image 3", "Artist 3", "2020", R.drawable.art8),
        ArtSpace("art9", "Image 3", "Artist 3", "2020", R.drawable.art9),
        ArtSpace("art10", "Image 3", "Artist 3", "2020", R.drawable.art10),

    )
    var currentImageIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
    }
}



@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {
    Laboratorio__6Theme {
        GalleryScreen()
    }
}