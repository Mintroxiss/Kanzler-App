package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.mintroxis.kanzlerapp.ui.theme.Dimensions

@Composable
fun ContentColumn(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .padding(Dimensions.normalPadding)
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        content()
    }
}


