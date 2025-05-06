package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R

@Preview
@Composable
fun InfoIconButton() {
    IconButton(
        modifier = Modifier
            .padding(end = 6.dp)
            .size(36.dp),

        onClick = { /*TODO*/ },
        content = {
            Image(
                modifier = Modifier.fillMaxSize(),

                painter = painterResource(id = R.drawable.icon_info),
                contentDescription = stringResource(id = R.string.info_icon_description),
            )
        }
    )
}