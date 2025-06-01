package ru.mintroxis.kanzlerapp.domain

import androidx.lifecycle.ViewModel

sealed class AllBannersScreenState {
    data object Initial : AllBannersScreenState()

    data class AllBanners(val banners: List<ContentBanner>) : AllBannersScreenState()
}