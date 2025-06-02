package ru.mintroxis.kanzlerapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White

@Composable
fun BoxScope.FloatingBackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        modifier = modifier
            .size(40.dp)
            .align(Alignment.TopStart),
        onClick = { onClick() },
        containerColor = Red,
        contentColor = White
    ) {
        Icon(
            painter = painterResource(id = R.drawable.go_back_icon),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun PreviewBackButton() {
    Box {
        FloatingBackButton(onClick = {})
    }
}