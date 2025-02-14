package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.Dimensions

@Composable
fun BrightButton(text: String, action: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(top = Dimensions.microPadding)
            .size(width = Dimensions.baseButtonWidth, height = Dimensions.baseButtonHeight),

        onClick = action,

        elevation = ButtonDefaults.buttonElevation(defaultElevation = Dimensions.baseButtonElevation),
        shape = RoundedCornerShape(Dimensions.baseButtonShape),
        colors = ButtonDefaults.buttonColors(containerColor = DeepRed)
    ) {
        Text(
            modifier = Modifier,

            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
        )
    }
}