package ru.mintroxis.kanzlerapp.ui.presentation.utils

import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.presentation.navigation.Screen

sealed class MainScreenBarItems(
    val screen: Screen,
    val iconID: Int,
    val textID: Int,
    val contentDescriptionID: Int,
    val topBarTextID: Int
) {

    data object Home : MainScreenBarItems(
        screen = Screen.Home,
        textID = R.string.home,
        iconID = R.drawable.home_icon,
        contentDescriptionID = R.string.home_icon,
        topBarTextID = R.string.hello
    )

    data object QR : MainScreenBarItems(
        screen = Screen.QR,
        textID = R.string.qr,
        iconID = R.drawable.qr_icon,
        contentDescriptionID = R.string.qr_icon,
        topBarTextID = R.string.qr_code
    )

    data object Profile : MainScreenBarItems(
        screen = Screen.Profile,
        textID = R.string.profile,
        iconID = R.drawable.profile_icon,
        contentDescriptionID = R.string.profile_icon,
        topBarTextID = R.string.profile
    )
}