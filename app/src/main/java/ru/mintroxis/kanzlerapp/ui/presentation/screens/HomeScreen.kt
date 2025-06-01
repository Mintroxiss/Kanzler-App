package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.ContentBanner
import ru.mintroxis.kanzlerapp.domain.HomeScreenState
import ru.mintroxis.kanzlerapp.ui.presentation.components.AddressBanner
import ru.mintroxis.kanzlerapp.ui.presentation.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Grey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily
import ru.mintroxis.kanzlerapp.vm.HomeViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel()
    val screenState = viewModel.homeScreenState.observeAsState(
        HomeScreenState.Initial
    )
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
                        bonuses = currentState.bonuses
                    )

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        stringResource(R.string.interesting),
                        openAllAction = { /*TODO*/ }) {
                        for (item in currentState.interestingBannerList) {
                            ClickableImageWithTextElement(item)
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        stringResource(R.string.promotions),
                        openAllAction = { /*TODO*/ }) {
                        for (item in currentState.promotionBannerList) {
                            ClickableImageWithTextElement(item)
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    ScrollableContent(
                        text = stringResource(R.string.store_addresses),
                        openAllAction = { /*TODO*/ }) {
                        for (item in currentState.addressesBannerList) AddressBanner(item)
                    }
                }

                is HomeScreenState.Initial -> {

                }
            }


            Spacer(Modifier.height(28.dp))

            SocialMediaSection()

            Spacer(modifier = Modifier.height(400.dp))
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
            Spacer(modifier = Modifier.width(15.dp))

            scrollableItems()

            Spacer(modifier = Modifier.width(24.dp))
        }
    }
}

@Composable
private fun ClickableImageWithTextElement(item: ContentBanner) {
    Column(modifier = Modifier.padding(start = 10.dp)) {
        Image(
            modifier = Modifier
                .size(width = 248.dp, height = 126.dp)
                .clip(RoundedCornerShape(10))
                .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10))
                .clickable { /*TODO*/ },
            painter = painterResource(item.imageID),
            contentDescription = "",
            contentScale = ContentScale.Crop
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
private fun BonusCardElement(qrImage: Int, bonuses: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
            .clip(RoundedCornerShape(10))
            .background(Red)
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
                .size(126.dp)
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


