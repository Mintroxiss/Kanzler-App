package ru.mintroxis.kanzlerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    homeMainScreenContent: @Composable () -> Unit,
    allInterestingBannersScreenContent: @Composable () -> Unit,
) {
    navigation(startDestination = Screen.HomeMain.route, route = Screen.Home.route) {
        composable(Screen.HomeMain.route) {
            homeMainScreenContent()
        }
        composable(Screen.AllInterestingBanners.route) {
            allInterestingBannersScreenContent()
        }
    }
}