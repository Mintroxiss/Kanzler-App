package ru.mintroxis.kanzlerapp.ui.screens

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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.mintroxis.kanzlerapp.domain.HomeScreenState
import ru.mintroxis.kanzlerapp.ui.MainScreenBarItems
import ru.mintroxis.kanzlerapp.ui.navigation.AppNavGraph
import ru.mintroxis.kanzlerapp.ui.navigation.NavigationState
import ru.mintroxis.kanzlerapp.ui.navigation.Screen
import ru.mintroxis.kanzlerapp.ui.navigation.rememberNavigationState
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily
import ru.mintroxis.kanzlerapp.ui.theme.rubikOneFamily
import ru.mintroxis.kanzlerapp.vm.HomeViewModel

@Preview
@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

    val buttons = listOf(
        MainScreenBarItems.Home, MainScreenBarItems.QR, MainScreenBarItems.Profile
    )

    Scaffold(
        modifier = Modifier
            .background(color = DarkWhite)
            .safeDrawingPadding(),
        topBar = {
            val currentRoute = navBackStackEntry?.destination?.route
            ScaffoldTopBar(buttons = buttons, currentRoute = currentRoute)
        },
        bottomBar = {
            ScaffoldBottomBar(
                buttons = buttons,
                navBackStackEntry = navBackStackEntry,
                navigationState = navigationState
            )
        },
    ) { paddingValues ->
        val homeViewModel: HomeViewModel = viewModel()
        val homeScreenState = homeViewModel.homeScreenState.observeAsState(HomeScreenState.Initial)
        val currentState = homeScreenState.value

        AppNavGraph(modifier = Modifier.padding(paddingValues),
            navHostController = navigationState.navHostController,
            homeMainScreenContent = {
                HomeMainScreen(
                    screenState = homeScreenState,
                    allInterestingBannersClickListener = {
                        navigationState.navigateTo(Screen.AllInterestingBanners.route)
                    },
                    allPromotionsBannerClickListener = {
                        navigationState.navigateTo(Screen.AllPromotionsBanners.route)
                    },
                    allAddressBannerClickListener = {
                        navigationState.navigateTo(Screen.AllAddressBanners.route)
                    },
                    qrCodeBannerClickListener = {
                        navigationState.navigateTo(Screen.QR.route)
                    }
                )
            },
            allInterestingBannersScreenContent = {
                if (currentState is HomeScreenState.Home) {
                    AllBannersScreen(
                        banners = currentState.interestingBannerList,
                        backButtonOnClickListener = {
                            navigationState.navigateTo(Screen.HomeMain.route)
                        }
                    )
                }
            },
            allPromotionsBannersScreenContent = {
                if (currentState is HomeScreenState.Home) {
                    AllBannersScreen(
                        banners = currentState.promotionsBannerList,
                        backButtonOnClickListener = {
                            navigationState.navigateTo(Screen.HomeMain.route)
                        }
                    )
                }
            },
            allAddressBannersContent = {
                if (currentState is HomeScreenState.Home) {
                    AllAddressBannersScreen(
                        backButtonOnClickListener = {
                            navigationState.navigateTo(Screen.HomeMain.route)
                        },
                        banners = currentState.addressesBannerList
                    )
                }
            },
            qrScreenContent = { QRScreen() },
            profileScreenContent = { ProfileScreen() })
    }
}

@Composable
private fun ScaffoldBottomBar(
    buttons: List<MainScreenBarItems>,
    navBackStackEntry: NavBackStackEntry?,
    navigationState: NavigationState
) {
    Column {
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = LightGrey)
        NavigationBar(containerColor = DarkWhite) {
            buttons.forEach { item ->
                val selectedChecked = navBackStackEntry?.destination?.hierarchy?.any {
                    it.route == item.screen.route
                } ?: false

                NavigationBarItem(
                    selected = selectedChecked,
                    onClick = { navigationState.navigateTo(item.screen.route) },
                    icon = {
                        Image(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(item.iconID),
                            contentDescription = stringResource(item.contentDescriptionID),
                            colorFilter = if (selectedChecked) ColorFilter.tint(
                                color = White
                            )
                            else ColorFilter.tint(color = Color.Black)
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
                .align(Alignment.BottomCenter), color = LightGrey
        )
    }
}



