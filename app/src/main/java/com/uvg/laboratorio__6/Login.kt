package com.uvg.laboratorio__6

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio__6.ui.theme.Laboratorio__6Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio__6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                MainLogin()
                }
            }
        }
    }
}


sealed class ScreenOption(val title: String){
    object LoginScreenGaleria : ScreenOption("Login")
}




@Composable
fun MainLogin() {
    var text by remember { mutableStateOf("") }
    val screenOptions = listOf(
        ScreenOption.LoginScreenGaleria
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "Bienvenido a Galerias",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(10.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
            )
        }
        items(screenOptions) { screenOption ->
            Button(
                onClick = {
                    //currentScreen = screenOption
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = screenOption.title,
                    color = Color.White
                )
            }
        }

    }

}



//Nombre del usuario
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cajatext() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Nombre de usuario") },
        textStyle = TextStyle(color = Color.Black),
    )
}

//Contraseña
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contraUser(){
    var contra by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = contra,
        onValueChange = {
            contra = it
        },
        label = { Text(text = "Contraseña") },
        placeholder = { Text(text = "Inserte la contraseña")
        },
        textStyle = TextStyle(color = Color.Black),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}






@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Laboratorio__6Theme {

    }
}