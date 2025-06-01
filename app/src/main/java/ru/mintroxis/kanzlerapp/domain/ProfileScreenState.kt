package ru.mintroxis.kanzlerapp.domain

sealed class ProfileScreenState {

    data object Initial : ProfileScreenState()

    data class Profile(
        val name: String,
        val phone: String,
        val bonuses: String,
        val discount: String,
        val addressesBannerList: List<AddressBanner>
    ) : ProfileScreenState()
}
