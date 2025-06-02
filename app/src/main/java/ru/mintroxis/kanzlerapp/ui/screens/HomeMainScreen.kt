package ru.mintroxis.kanzlerapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.ContentBanner
import ru.mintroxis.kanzlerapp.domain.HomeScreenState
import ru.mintroxis.kanzlerapp.ui.components.AddressBanner
import ru.mintroxis.kanzlerapp.ui.components.BannerElement
import ru.mintroxis.kanzlerapp.ui.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Composable
fun HomeMainScreen(
    allInterestingBannersClickListener: () -> Unit,
    allPromotionsBannerClickListener: () -> Unit,
    allAddressBannerClickListener: () -> Unit,
    qrCodeBannerClickListener: () -> Unit,
    screenState: State<HomeScreenState>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkWhite)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.home_background),
            contentDescription = stringResource(R.string.home_background),
            contentScale = ContentScale.Crop
        )

        MainScreenColumn {
            Spacer(Modifier.height(35.dp))

            when (val currentState = screenState.value) {
                is HomeScreenState.Home -> {
                    BonusCardElement(
                        qrImage = currentState.qrImage,
                        bonuses = currentState.bonuses,
                        onItemClickListener = { qrCodeBannerClickListener() }
                    )

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        stringResource(R.string.interesting),
                        openAllAction = { allInterestingBannersClickListener() }
                    ) {
                        for (item in currentState.interestingBannerList) {
                            Spacer(modifier = Modifier.width(25.dp))
                            ClickableBannerWithTitleElement(item)
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        text = stringResource(R.string.promotions),
                        openAllAction = { allPromotionsBannerClickListener() }) {
                        for (item in currentState.promotionsBannerList) {
                            Spacer(modifier = Modifier.width(25.dp))
                            ClickableBannerWithTitleElement(item)
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        text = stringResource(R.string.store_addresses),
                        openAllAction = { allAddressBannerClickListener() }) {
                        for (item in currentState.addressesBannerList) {
                            Spacer(modifier = Modifier.width(25.dp))
                            AddressBanner(
                                modifier = Modifier.size(width = 216.dp, height = 114.dp),
                                item = item
                            )
                        }
                    }
                }

                is HomeScreenState.Initial -> {

                }
            }

            Spacer(Modifier.height(28.dp))

            SocialMediaSection()

            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}

@Composable
private fun SocialMediaSection() {
    Row(
        modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SocialMediaButton(
            onClick = { /*TODO*/ },
            painter = painterResource(R.drawable.instagram_icon),
            contentDescription = stringResource(R.string.instagram_icon),
            text = stringResource(R.string.instagram)
        )

        SocialMediaButton(
            onClick = { /*TODO*/ },
            painter = painterResource(R.drawable.whatsapp_icon),
            contentDescription = stringResource(R.string.whatsapp_icon),
            text = stringResource(R.string.whatsapp)
        )
    }
}

@Composable
private fun SocialMediaButton(
    onClick: () -> Unit, painter: Painter, contentDescription: String, text: String
) {
    Button(
        modifier = Modifier.size(width = 175.dp, height = 55.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White, contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(33.dp),
                painter = painter,
                contentDescription = contentDescription,
            )
            Text(
                text = text,
                fontFamily = rubikFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun ScrollableContent(
    text: String,
    openAllAction: () -> Unit,
    scrollableItems: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 25.dp, top = 12.dp),
                text = text,
                fontFamily = rubikFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

            OpenContentButton(stringResource(R.string.all), openAllAction)
        }

        Row(Modifier.horizontalScroll(rememberScrollState())) {
            scrollableItems()

            Spacer(modifier = Modifier.width(25.dp))
        }
    }
}

@Composable
private fun ClickableBannerWithTitleElement(item: ContentBanner) {
    Column(modifier = Modifier) {
        BannerElement(
            modifier = Modifier
                .size(width = 262.dp, height = 156.dp),
            item = item,
            clickable = { /*TODO*/ }
        )

        Spacer(Modifier.height(3.dp))

        Text(
            text = item.title,
            fontFamily = rubikFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
        )
    }
}


@Composable
private fun OpenContentButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(end = 18.dp)
            .width(68.dp)
    ) {
        TextButton(
            modifier = Modifier.align(Alignment.CenterStart), onClick = onClick
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = rubikFamily,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(28.dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(R.drawable.open_icon),
            contentDescription = stringResource(
                R.string.open_icon
            )
        )
    }
}

@Composable
private fun BonusCardElement(onItemClickListener: () -> Unit, qrImage: Int, bonuses: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
            .clip(RoundedCornerShape(10))
            .background(Red)
            .clickable { onItemClickListener() }
            .padding(21.dp)
    ) {
        Text(
            text = stringResource(R.string.bonus_card),
            fontFamily = rubikFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = White
        )

        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = White, fontFamily = rubikFamily)) {
                    withStyle(SpanStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)) {
                        append(stringResource(R.string.bonuses))
                    }
                    withStyle(SpanStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)) {
                        append(bonuses)
                    }
                }

            }, modifier = Modifier.align(Alignment.BottomStart)
        )

        Box(
            modifier = Modifier
                .size(134.dp)
                .clip(RoundedCornerShape(10))
                .background(White)
                .align(Alignment.CenterEnd)
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(qrImage),
                contentDescription = stringResource(
                    R.string.qr_code
                )
            )
        }
    }
}


