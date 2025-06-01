package ru.mintroxis.kanzlerapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.ui.theme.Red

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.authTextFieldArgs(): Modifier {
    return this
        .size(width = 332.dp, height = 60.dp)
        .border(
            width = 1.dp,
            color = Red,
            shape = RoundedCornerShape(14.dp)
        )
        .shadow(
            elevation = 8.dp,
            shape = RoundedCornerShape(14.dp),
            ambientColor = Color.Black,
            clip = true
        )
}