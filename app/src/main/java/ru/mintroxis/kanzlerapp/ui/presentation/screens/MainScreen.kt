package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
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
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.AppNavGraph
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.NavigationState
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.rememberNavigationState
import ru.mintroxis.kanzlerapp.ui.presentation.utils.MainScreenBarItems
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily
import ru.mintroxis.kanzlerapp.ui.theme.rubikOneFamily

@Preview
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val buttons = listOf(
        MainScreenBarItems.Home,
        MainScreenBarItems.QR,
        MainScreenBarItems.Profile
    )

    Scaffold(
        modifier = Modifier
            .background(color = DarkWhite)
            .safeDrawingPadding(),
        topBar = {
            ScaffoldTopBar(buttons = buttons, currentRoute = currentRoute)
        },
        bottomBar = {
            ScaffoldBottomBar(buttons, currentRoute, navigationState)
        },
    ) { paddingValues ->
        AppNavGraph(
            modifier = Modifier.padding(paddingValues),
            navHostController = navigationState.navHostController,
            homeScreenContent = { HomeScreen() },
            qrScreenContent = { QRScreen() },
            profileScreenContent = { ProfileScreen() }
        )
    }
}

@Composable
private fun ScaffoldBottomBar(
    buttons: List<MainScreenBarItems>,
    currentRoute: String?,
    navigationState: NavigationState
) {
    Column {
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = LightGrey)
        NavigationBar(containerColor = DarkWhite) {
            buttons.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.screen.route,
                    onClick = { navigationState.navigateTo(item.screen.route) },
                    icon = {
                        Image(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(item.iconID),
                            contentDescription = stringResource(item.contentDescriptionID),
                            colorFilter = if (currentRoute == item.screen.route)
                                ColorFilter.tint(color = White)
                            else
                                ColorFilter.tint(color = Color.Black)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(item.textID),
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
}

@Composable
private fun ScaffoldTopBar(buttons: List<MainScreenBarItems>, currentRoute: String?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(color = DarkWhite)
    ) {
        var text = ""
        buttons.forEach { item ->
            if (item.screen.route == currentRoute) {
                text = stringResource(item.topBarTextID)
                if (item.screen.route == MainScreenBarItems.Home.screen.route) {
                    text += "Роман!"  // TODO
                }
                return@forEach
            }
        }
        Text(
            modifier = Modifier
                .padding(start = 28.dp)
                .align(Alignment.CenterStart),
            text = text,
            fontSize = 20.sp,
            fontFamily = rubikOneFamily,
            fontWeight = FontWeight.Normal,
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            color = LightGrey
        )
    }
}



