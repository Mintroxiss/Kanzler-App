package ru.mintroxis.kanzlerapp.ui.presentation.utils

import ru.mintroxis.kanzlerapp.R

sealed class BottomBarItems(
    val text: Int,
    val icon: Int,
    val contentDescription: Int
) {
    data object Home : BottomBarItems(
        text = R.string.home,
        icon = R.drawable.home_icon,
        contentDescription = R.string.home_icon,
    )

    data object QR : BottomBarItems(
        text = R.string.qr,
        icon = R.drawable.qr_icon,
        contentDescription = R.string.qr_icon,
    )

    data object  Profile : BottomBarItems(
        text = R.string.profile,
        icon = R.drawable.profile_icon,
        contentDescription = R.string.profile_icon
    )
}