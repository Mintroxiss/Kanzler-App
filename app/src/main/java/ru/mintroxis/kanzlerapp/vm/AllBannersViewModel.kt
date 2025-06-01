package ru.mintroxis.kanzlerapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.AllBannersScreenState
import ru.mintroxis.kanzlerapp.domain.ContentBanner

class AllBannersViewModel : ViewModel() {
    private val _allBannersScreenState =
        MutableLiveData<AllBannersScreenState>(AllBannersScreenState.Initial)
    val allBannersScreenState: LiveData<AllBannersScreenState> = _allBannersScreenState

    init {
        loadAllBanners()
    }

    fun loadAllBanners() {
        _allBannersScreenState.value = AllBannersScreenState.AllBanners(
            listOf(
                ContentBanner(
                    imageID = R.drawable.get_pen,
                    title = "Получи ручку в подарок",
                    text = "",
                    date = ""
                ),
                ContentBanner(
                    imageID = R.drawable.calculator,
                    title = "Калькуляторы - зло!",
                    text = "",
                    date = ""
                ),
                ContentBanner(
                    imageID = R.drawable.get_pen,
                    title = "Получи конфеты в подарок",
                    text = "",
                    date = ""
                ),
                ContentBanner(
                    imageID = R.drawable.get_pen,
                    title = "Получи конфеты в подарок",
                    text = "",
                    date = ""
                ),
                ContentBanner(
                    imageID = R.drawable.get_pen,
                    title = "Получи конфеты в подарок",
                    text = "",
                    date = ""
                ),
            )
        )
    }
}