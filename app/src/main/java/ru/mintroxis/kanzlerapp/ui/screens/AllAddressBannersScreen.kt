package ru.mintroxis.kanzlerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.domain.AddressBanner
import ru.mintroxis.kanzlerapp.ui.components.AddressBanner
import ru.mintroxis.kanzlerapp.ui.components.FloatingBackButton
import ru.mintroxis.kanzlerapp.ui.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite

@Composable
fun AllAddressBannersScreen(backButtonOnClickListener: () -> Unit, banners: List<AddressBanner>) {
    Box(modifier = Modifier.fillMaxSize()) {
        MainScreenColumn(
            modifier = Modifier
                .background(color = DarkWhite)
        ) {
            banners.forEach { item ->
                Spacer(modifier = Modifier.height(30.dp))

                AddressBanner(
                    modifier = Modifier.size(width = 276.dp, height = 174.dp),
                    item = item,
                    contentScale = 20
                )
            }

            Spacer(modifier = Modifier.height(300.dp))
        }

        FloatingBackButton(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            onClick = { backButtonOnClickListener() })
    }
}