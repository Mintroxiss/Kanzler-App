package ru.mintroxis.kanzlerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R

@Composable
fun BoxScope.BackIconButton(onClick: () -> Unit) {
    IconButton(
        modifier = Modifier
            .size(36.dp)
            .align(Alignment.BottomStart),

        onClick = onClick,
        content = {
            Image(
                modifier = Modifier.fillMaxSize(),

                painter = painterResource(id = R.drawable.go_back_icon),
                contentDescription = stringResource(R.string.go_back),
            )
        }
    )
}

@Preview
@Composable
private fun PreviewBackIconButton() {
    Box {
        BackIconButton {}
    }
}