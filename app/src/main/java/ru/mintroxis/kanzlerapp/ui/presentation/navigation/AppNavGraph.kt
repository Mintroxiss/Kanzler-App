package ru.mintroxis.kanzlerapp.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    qrScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { homeScreenContent() }
        composable(Screen.QR.route) { qrScreenContent() }
        composable(Screen.Profile.route) { profileScreenContent() }
    }
}