package ru.mintroxis.kanzlerapp.ui.presentation.navigation

sealed class Screen(
    val route: String
) {
    data object Home: Screen(ROUTE_HOME)
    data object QR: Screen(ROUTE_QR)
    data object Profile: Screen(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_QR = "qr"
        const val ROUTE_PROFILE = "profile"
    }
}