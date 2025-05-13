package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R

@Preview
@Composable
fun PasswordInfoText() {
    Text(
        modifier = Modifier,
        text = stringResource(id = R.string.password_info),
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        lineHeight = 13.sp,
    )
}