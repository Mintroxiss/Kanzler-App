package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R

@Composable
fun InfoIconButton(modifier: Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier.size(36.dp),

        onClick = onClick,
        content = {
            Image(
                modifier = Modifier.fillMaxSize(),

                painter = painterResource(id = R.drawable.icon_info),
                contentDescription = stringResource(id = R.string.info_icon_description),
            )
        }
    )
}

@Preview
@Composable
private fun PreviewInfoIconButton() {
    InfoIconButton(Modifier) {}
}