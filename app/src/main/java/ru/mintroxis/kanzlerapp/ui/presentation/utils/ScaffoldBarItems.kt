package ru.mintroxis.kanzlerapp.ui.presentation.utils

import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.Screen

sealed class ScaffoldBarItems(
    val screen: Screen,
    val text: Int,
    val icon: Int,
    val contentDescription: Int
) {

    data object Home : ScaffoldBarItems(
        screen = Screen.Home,
        text = R.string.home,
        icon = R.drawable.home_icon,
        contentDescription = R.string.home_icon
    )

    data object QR : ScaffoldBarItems(
        screen = Screen.QR,
        text = R.string.qr,
        icon = R.drawable.qr_icon,
        contentDescription = R.string.qr_icon,
    )

    data object Profile : ScaffoldBarItems(
        screen = Screen.Profile,
        text = R.string.profile,
        icon = R.drawable.profile_icon,
        contentDescription = R.string.profile_icon,
    )
}