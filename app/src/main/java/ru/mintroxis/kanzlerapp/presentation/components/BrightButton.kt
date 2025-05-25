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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.ui.theme.Red

@Composable
fun BrightButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(top = 6.dp)
            .size(width = 332.dp, height = 60.dp),

        onClick = onClick,

        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Red)
    ) {
        Text(
            modifier = Modifier,

            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
        )
    }
}

@Preview
@Composable
private fun PreviewBrightButton() {
    BrightButton("Text") {}
}