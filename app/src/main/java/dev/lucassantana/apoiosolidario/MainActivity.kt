package dev.lucassantana.apoiosolidario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.lucassantana.apoiosolidario.screens.InitialScreen
import dev.lucassantana.apoiosolidario.ui.theme.ApoioSolidarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApoioSolidarioTheme {
                InitialScreen()
            }
        }
    }
}