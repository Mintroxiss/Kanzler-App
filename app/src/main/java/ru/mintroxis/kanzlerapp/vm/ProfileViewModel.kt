package ru.mintroxis.kanzlerapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mintroxis.kanzlerapp.domain.AddressBanner
import ru.mintroxis.kanzlerapp.domain.ProfileScreenState

class ProfileViewModel : ViewModel() {
    private val _profileScreenData = MutableLiveData<ProfileScreenState>(ProfileScreenState.Initial)
    val profileScreenState: LiveData<ProfileScreenState> = _profileScreenData

    init {
        loadProfile()
    }

    fun loadProfile() {
        _profileScreenData.value = ProfileScreenState.Profile(
            name = "Василий Петров",
            phone = "+996 (555)-77-66-55",
            bonuses = "150",
            discount = "5",
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