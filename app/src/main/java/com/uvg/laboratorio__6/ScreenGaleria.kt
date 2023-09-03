package com.uvg.laboratorio__6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
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

data class ArtSpace(val name: String, val author: String, val year: String, @DrawableRes val idImage: Int)



@Composable
fun ImageCard(image: Painter, title: String, author: String, year: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "Artista: $author", fontSize = 16.sp)
            Text(text = "Año: $year", fontSize = 12.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen() {
    var selectedArtIndex by remember { mutableStateOf(0) }
    val galleryImages = listOf(
        ArtSpace("art1", "Ruth", "2020", R.drawable.art1),
        ArtSpace("art1", "Image 2", "Artist 2", R.drawable.art2),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art3),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art4),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art5),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art6),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art7),
        ArtSpace("art1", "Image 3", "Artist 3", R.drawable.art8),
        ArtSpace("art9", "Image 3", "Artist 3", R.drawable.art9),
        ArtSpace("art10", "Image 3", "Artist 3", R.drawable.art10),
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.cerrar_sesion2),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Art Space App",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(id = galleryImages[selectedArtIndex].idImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
                .padding(horizontal = 10.dp)
                .clip(shape = MaterialTheme.shapes.large)
        )

        Spacer(modifier = Modifier.height(16.dp))


        val selectedArtwork = galleryImages[selectedArtIndex]
        Text(
            text = selectedArtwork.name,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 180.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Artista: ${selectedArtwork.author}",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 160.dp)
        )
        Text(
            text = "Año: ${selectedArtwork.year}",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 177.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (selectedArtIndex > 0) {
                        selectedArtIndex--
                    }
                },
                enabled = selectedArtIndex > 0
            ) {
                Text(text = "Anterior")
            }

            Button(
                onClick = {
                    if (selectedArtIndex < galleryImages.size - 1) {
                        selectedArtIndex++
                    }
                },
                enabled = selectedArtIndex < galleryImages.size - 1
            ) {
                Text(text = "Siguiente")
            }
        }
    }
}


@Composable
fun ArtworkItem(
    artwork: ArtSpace,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = artwork.idImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = artwork.name,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Artista: ${artwork.author}",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Año: ${artwork.year}",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {
    Laboratorio__6Theme {
        GalleryScreen()
    }
}