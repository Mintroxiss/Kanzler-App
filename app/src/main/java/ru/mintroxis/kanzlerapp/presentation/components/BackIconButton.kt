package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R

@Composable
fun BoxScope.BackIconButton() {
    IconButton(
        modifier = Modifier
            .size(36.dp)
            .align(Alignment.BottomStart),

        onClick = { /*TODO*/ },
        content = {
            Image(
                modifier = Modifier.fillMaxSize(),

                painter = painterResource(id = R.drawable.go_back_icon),
                contentDescription = stringResource(R.string.go_back),
            )
        }
    )
}