package ru.mintroxis.kanzlerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.mintroxis.kanzlerapp.presentation.screens.LoginScreen
import ru.mintroxis.kanzlerapp.ui.theme.KanzlerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KanzlerAppTheme {
                LoginScreen()
            }
        }
    }
}

