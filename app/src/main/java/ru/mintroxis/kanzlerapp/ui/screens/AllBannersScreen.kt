package ru.mintroxis.kanzlerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.domain.ContentBanner
import ru.mintroxis.kanzlerapp.ui.components.BannerElement
import ru.mintroxis.kanzlerapp.ui.components.FloatingBackButton
import ru.mintroxis.kanzlerapp.ui.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Composable
fun AllBannersScreen(backButtonOnClickListener: () -> Unit, banners: List<ContentBanner>) {
    Box(modifier = Modifier.fillMaxSize()) {
        MainScreenColumn(
            modifier = Modifier
                .background(color = DarkWhite)
        ) {
            banners.forEachIndexed { index, item ->
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

        FloatingBackButton(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            onClick = { backButtonOnClickListener() })
    }
}
