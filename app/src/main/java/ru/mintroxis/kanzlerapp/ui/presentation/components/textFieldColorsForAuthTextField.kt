package ru.mintroxis.kanzlerapp.ui.presentation.components

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.mintroxis.kanzlerapp.ui.theme.AlternativeWhite

@Composable
fun textFieldColorsForAuthTextField(): TextFieldColors = TextFieldDefaults.colors(
    focusedContainerColor = AlternativeWhite,
    unfocusedContainerColor = AlternativeWhite,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    cursorColor = Color.Black,
)