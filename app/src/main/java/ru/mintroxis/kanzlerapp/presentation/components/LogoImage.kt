package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R

@Preview
@Composable
fun LogoImage() {
    Image(
        modifier = Modifier.size(width = 320.dp, height = 150.dp),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo_description)
    )
}