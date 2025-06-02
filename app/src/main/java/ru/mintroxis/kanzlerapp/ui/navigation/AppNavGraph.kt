package ru.mintroxis.kanzlerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    homeMainScreenContent: @Composable () -> Unit,
    allInterestingBannersScreenContent: @Composable () -> Unit,
    allPromotionsBannersScreenContent: @Composable () -> Unit,
    allAddressBannersContent: @Composable () -> Unit,
    qrScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        homeScreenNavGraph(
            homeMainScreenContent = { homeMainScreenContent() },
            allInterestingBannersScreenContent = { allInterestingBannersScreenContent() },
            allPromotionsBannersContent = { allPromotionsBannersScreenContent() },
            allAddressBannersContent = { allAddressBannersContent() }
        )
        composable(Screen.QR.route) { qrScreenContent() }
        composable(Screen.Profile.route) { profileScreenContent() }
    }
}