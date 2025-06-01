package ru.mintroxis.kanzlerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mintroxis.kanzlerapp.domain.AllBannersScreenState
import ru.mintroxis.kanzlerapp.ui.components.BannerElement
import ru.mintroxis.kanzlerapp.ui.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily
import ru.mintroxis.kanzlerapp.vm.AllBannersViewModel

@Preview
@Composable
fun AllBannersScreen() {
    MainScreenColumn(modifier = Modifier.background(color = DarkWhite)) {
        val viewModel: AllBannersViewModel = viewModel()
        val screenState =
            viewModel.allBannersScreenState.observeAsState(AllBannersScreenState.Initial)

        when (val currentState = screenState.value) {
            is AllBannersScreenState.AllBanners -> {
                currentState.banners.forEachIndexed { index, item ->
                    Spacer(modifier = Modifier.height(34.dp))

                    if (index != 0) {
                        HorizontalDivider(modifier = Modifier.width(330.dp), color = Red)

                        Spacer(modifier = Modifier.height(30.dp))
                    }

                    Text(
                        text = item.title,
                        fontFamily = rubikFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    BannerElement(
                        modifier = Modifier.size(width = 300.dp, height = 176.dp),
                        item = item,
                        clickable = { /*TODO*/ }
                    )
                }

                Spacer(modifier = Modifier.height(300.dp))
            }

            is AllBannersScreenState.Initial -> {

            }
        }
    }
}