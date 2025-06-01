package ru.mintroxis.kanzlerapp.domain

sealed class HomeScreenState {

    data object Initial : HomeScreenState()

    data class Home(
        val qrImage: Int,
        val bonuses: String,
        val interestingBannerList: List<ContentBanner>,
        val promotionBannerList: List<ContentBanner>,
        val addressesBannerList: List<AddressBanner>
    ) : HomeScreenState()
}

