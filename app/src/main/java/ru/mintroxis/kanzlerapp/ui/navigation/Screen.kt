package ru.mintroxis.kanzlerapp.ui.navigation

sealed class Screen(
    val route: String
) {
    data object Home: Screen(ROUTE_HOME)
    data object QR: Screen(ROUTE_QR)
    data object Profile: Screen(ROUTE_PROFILE)
    data object HomeMain: Screen(ROUTE_HOME_MAIN)
    data object AllInterestingBanners: Screen(ROUT_ALL_INTERESTING_BANNERS)
    data object AllPromotionsBanners: Screen(ROUT_ALL_PROMOTIONS_BANNERS)
    data object AllAddressBanners: Screen(ROUT_ALL_ADDRESS_BANNERS)

    private companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_HOME_MAIN = "home_main"
        const val ROUT_ALL_PROMOTIONS_BANNERS = "all_promotions_banners"
        const val ROUT_ALL_INTERESTING_BANNERS = "all_interesting_banners"
        const val ROUT_ALL_ADDRESS_BANNERS = "all_address_banners"
        const val ROUTE_QR = "qr"
        const val ROUTE_PROFILE = "profile"
    }
}