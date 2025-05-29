package ru.mintroxis.kanzlerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.mintroxis.kanzlerapp.ui.presentation.screens.MainScreen
import ru.mintroxis.kanzlerapp.ui.presentation.screens.ProfileScreen
import ru.mintroxis.kanzlerapp.vm.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}
