package com.uvg.laboratorio__6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import com.uvg.laboratorio__6.ui.theme.Laboratorio__6Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio__6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLogin(onLoginClick = { _, _ -> })
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin(
    onLoginClick: (String, String) -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current


    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(16.dp)

    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.imagencentrall),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp)
                    .height(170.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Bienvenido a Galerias",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .shadow(15.dp)
                    .background(color = Color.Black)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 50.dp)
                        .align(Alignment.Center)
                ) {
                    TextField(
                        value = username,
                        onValueChange = { newValue ->
                            if (newValue.length <= 10) {
                                username = newValue
                            }
                        },
                        label = { Text("Usuario") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    )
                    TextField(
                        value = password,
                        onValueChange = { newValue ->
                            if (newValue.length <= 8) {
                                password = newValue
                            }
                        },
                        label = { Text("Contraseña") },
                        placeholder = { Text("Inserte la contraseña") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                    )
                }
            }
        }
        item {
            Button(
                onClick = {
                    if (username.isNotEmpty() && password.isNotEmpty() && IDUser(username, password)) {
                        onLoginClick(username, password)
                        val intent = Intent(context, ScreenGaleria::class.java)
                        context.startActivity(intent)
                        isLoggedOut = false
                    } else {
                        if (username.isEmpty()) {
                            Toast.makeText(context, "Por favor, ingresa un nombre de usuario", Toast.LENGTH_SHORT).show()
                        } else if (password.isEmpty()) {
                            Toast.makeText(context, "Por favor, ingresa una contraseña", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}


fun IDUser(username: String, password: String): Boolean {
    val IDCorrect = mapOf(

        //Ingresar esos datos exactos para iniciar sesión
        "userprueba" to "12345678",
    )
    return IDCorrect[username] == password
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Laboratorio__6Theme {
        MainLogin(onLoginClick = { _, _ -> })

    }
}