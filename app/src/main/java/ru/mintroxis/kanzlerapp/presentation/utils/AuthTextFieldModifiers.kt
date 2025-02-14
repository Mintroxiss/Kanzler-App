package ru.mintroxis.kanzlerapp.presentation.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.Dimensions

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.authTextFieldArgs(): Modifier {
    return this
        .size(width = Dimensions.textFieldWidth, height = Dimensions.textFieldHeight)
        .border(
            width = Dimensions.borderHeightOfTextField,
            color = DeepRed,
            shape = RoundedCornerShape(Dimensions.textFieldShape)
        )
        .shadow(
            elevation = Dimensions.textFieldElevation,
            shape = RoundedCornerShape(Dimensions.textFieldShape),
            ambientColor = Color.Black,
            clip = true
        )
}