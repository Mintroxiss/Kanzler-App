package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.ui.presentation.utils.BottomBarItems
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.Grey
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun ScaffoldScreen() {
    val buttons = listOf(BottomBarItems.Home, BottomBarItems.QR, BottomBarItems.Profile)

    Scaffold(
        modifier = Modifier.background(color = LightGrey),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp)
                    .background(color = DarkWhite)
                    .border(width = 1.dp, color = LightGrey)
            ) {

            }
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.border(width = 1.dp, color = LightGrey),
                containerColor = DarkWhite
            ) {
                var selected = 0

                buttons.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = {
                            Image(
                                modifier = Modifier.size(36.dp),
                                painter = painterResource(item.icon),
                                contentDescription = stringResource(item.contentDescription),
                                colorFilter = if (selected == index) ColorFilter.tint(color = White)
                                else ColorFilter.tint(
                                    color = Color.Black
                                )
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(item.text),
                                fontSize = 12.sp,
                                fontFamily = rubikFamily,
                                fontWeight = FontWeight.Light
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = DeepRed,
                        )
                    )
                }
            }
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        )
    }
}