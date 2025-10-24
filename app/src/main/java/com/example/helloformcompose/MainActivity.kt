package com.example.helloformcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloformcompose.ui.theme.HelloFormComposeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloFormComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloForm(modifier = Modifier.padding(innerPadding).padding(16.dp))
                }
            }
        }
    }
}
@Composable
fun HelloForm(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                message = if (name.isBlank()) {
                    "Introduce tu nombre"
                }
                else {
                    "👋 Hola, $name" }
                      }, modifier = Modifier.fillMaxWidth()) {
            Text("Saludar")
        }
        if (message.isNotEmpty()) {
            Text(text = message, style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HelloFormPreview() {
    HelloFormComposeTheme {
        HelloForm(modifier = Modifier.padding(16.dp))
    }
}
