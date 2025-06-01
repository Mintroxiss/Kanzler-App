package ru.mintroxis.kanzlerapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.AddressBanner
import ru.mintroxis.kanzlerapp.domain.ContentBanner
import ru.mintroxis.kanzlerapp.domain.HomeScreenState

class HomeViewModel : ViewModel() {
    private val _homeScreenState = MutableLiveData<HomeScreenState>(HomeScreenState.Initial)
    val homeScreenState: LiveData<HomeScreenState> = _homeScreenState

    init { loadHome() }

    fun loadHome() {
        _homeScreenState.value = HomeScreenState.Home(
            qrImage = R.drawable.qr_code,
            bonuses = "150",
            interestingBannerList = listOf(
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
            ),
            promotionBannerList = listOf(
                ContentBanner(
                    imageID = R.drawable.presents_from_attache,
                    title = "Attache несёт радость!",
                    text = "",
                    date = ""
                ), ContentBanner(
                    imageID = R.drawable.calculator,
                    title = "2 калькулятора\nпо цене 1",
                    text = "",
                    date = ""
                )
            ),
            addressesBannerList = listOf(
                AddressBanner(
                    street = "Гоголя/Огонбаева",
                    address = "Огонбаева Атая,222",
                    phone = "+996 777-90-22-33",
                    openingHours = "09:00 - 18:00"
                ),
                AddressBanner(
                    street = "Рубеля/Новодедова",
                    address = "Рубеля Охаё,222",
                    phone = "+992 737-94-21-03",
                    openingHours = "09:00 - 20:00"
                )
            )
        )
    }
}