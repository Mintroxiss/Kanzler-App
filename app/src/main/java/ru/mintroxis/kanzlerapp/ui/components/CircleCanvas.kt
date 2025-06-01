package ru.mintroxis.kanzlerapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import ru.mintroxis.kanzlerapp.ui.theme.TranspRed

@Composable
fun CircleCanvas(modifier: Modifier, width: Float, height: Float, radius: Float) {
    Canvas(
        modifier = modifier
    ) {
        drawCircle(
            color = TranspRed,
            radius = size.width * radius,
            center = Offset(size.width * width, size.height * height)
        )
    }
}