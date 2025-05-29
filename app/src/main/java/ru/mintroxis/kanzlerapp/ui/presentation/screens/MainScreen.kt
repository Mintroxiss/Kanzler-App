package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.AppNavGraph
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.Screen
import ru.mintroxis.kanzlerapp.ui.presentation.utils.ScaffoldBarItems
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .background(color = DarkWhite)
            .safeDrawingPadding(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(39.dp)
                    .background(color = DarkWhite)
            ) {
                HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = LightGrey)
            }
        },
        bottomBar = {
            Column {
                HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = LightGrey)
                NavigationBar(containerColor = DarkWhite) {
                    val buttons = listOf(
                        ScaffoldBarItems.Home,
                        ScaffoldBarItems.QR,
                        ScaffoldBarItems.Profile
                    )
                    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    buttons.forEach { item ->
                        NavigationBarItem(
                            selected = currentRoute == item.screen.route,
                            onClick = {
                                navHostController.navigate(item.screen.route) {
                                    popUpTo(Screen.Home.route)
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                Image(
                                    modifier = Modifier.size(28.dp),
                                    painter = painterResource(item.icon),
                                    contentDescription = stringResource(item.contentDescription),
                                    colorFilter = if (currentRoute == item.screen.route)
                                        ColorFilter.tint(color = White)
                                    else
                                        ColorFilter.tint(color = Color.Black)
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
                                indicatorColor = Red,
                            )
                        )
                    }
                }
            }
        }) { paddingValues ->
        AppNavGraph(
            modifier = Modifier.padding(paddingValues),
            navHostController = navHostController,
            homeScreenContent = { HomeScreen() },
            qrScreenContent = { QRScreen() },
            profileScreenContent = { ProfileScreen() }
        )
    }
}


