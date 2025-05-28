package ru.mintroxis.kanzlerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.mintroxis.kanzlerapp.presentation.screens.EnterTheCodeScreen
import ru.mintroxis.kanzlerapp.presentation.screens.HomeScreen
import ru.mintroxis.kanzlerapp.presentation.screens.LoginScreen
import ru.mintroxis.kanzlerapp.presentation.screens.ProfileScreen
import ru.mintroxis.kanzlerapp.presentation.screens.RecoverScreen
import ru.mintroxis.kanzlerapp.presentation.screens.RegistrationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            LoginScreen()
//            RegistrationScreen()
//            RecoverScreen()
//            EnterTheCodeScreen()
//            HomeScreen()
            ProfileScreen()
        }
    }
}
