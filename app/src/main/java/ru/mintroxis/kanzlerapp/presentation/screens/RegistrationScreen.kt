package ru.mintroxis.kanzlerapp.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import ru.mintroxis.kanzlerapp.presentation.components.ContentColumn
import ru.mintroxis.kanzlerapp.ui.theme.TranspRed
import ru.mintroxis.kanzlerapp.ui.theme.White

@Composable
fun RegistrationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),

        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        ContentColumn {
            InputSection()
        }
    }
}

@Composable
private fun InputSection() {

}

@Composable
private fun BackgroundImage() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        drawCircle(
            color = TranspRed,
            radius = size.width * 0.3f,
            center = Offset(size.width * 0.9f, size.height * 0.2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewRegistrationScreen() {
    RegistrationScreen()
}