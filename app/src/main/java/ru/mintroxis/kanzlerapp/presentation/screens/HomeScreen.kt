package ru.mintroxis.kanzlerapp.presentation.screens

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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.CircleCanvas
import ru.mintroxis.kanzlerapp.presentation.components.MainScaffold
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Grey
import ru.mintroxis.kanzlerapp.ui.theme.Lime
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily
import ru.mintroxis.kanzlerapp.ui.theme.rubikOneFamily

@Preview
@Composable
fun HomeScreen() {
    var parentSize by remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkWhite)
            .onGloballyPositioned { coordinates ->
                parentSize = coordinates.size
            }
    ) {
        Background(parentSize)

        MainScaffold {
            HeaderSection()

            BonusCardSection()

            Spacer(Modifier.height(28.dp))

            InterestingSection()

            Spacer(Modifier.height(28.dp))

            PromotionsSection()

            Spacer(Modifier.height(28.dp))

            AddressesSection()

            Spacer(Modifier.height(28.dp))

            SocialMediaSection()

            Spacer(modifier = Modifier.height(400.dp))
        }
    }
}

@Composable
private fun SocialMediaSection() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
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
    onClick: () -> Unit,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    Button(
        modifier = Modifier.size(width = 175.dp, height = 55.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
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
private fun AddressesSection() {
    val list = listOf(
        arrayOf("Гоголя/Огонбаева", "Огонбаева Атая,222", "+996 777-90-22-33", "09:00 - 18:00"),
        arrayOf("Рубеля/Новодедова", "Рубеля Охаё,222", "+992 737-94-21-03", "09:00 - 20:00")
    )

    ScrollableContent(
        text = stringResource(R.string.store_addresses),
        openAllAction = { /*TODO*/ }
    ) {
        for (item in list)
            AddressBanner(item)
    }
}

@Composable
private fun AddressBanner(item: Array<String>) {
    Box(
        Modifier
            .width(215.dp)
            .padding(start = 10.dp)
            .clip(RoundedCornerShape(5))
            .border(width = 1.dp, color = Lime, shape = RoundedCornerShape(5))
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Spacer(Modifier.height(13.dp))

            Text(
                text = item[0],
                fontFamily = rubikFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(2.dp))

            Text(
                text = item[1],
                fontFamily = rubikFamily,
                fontSize = 13.sp,
            )

            Spacer(Modifier.height(1.dp))

            Text(
                text = item[2],
                fontFamily = rubikFamily,
                fontSize = 11.sp,
            )

            Spacer(Modifier.height(6.dp))

            HorizontalDivider(
                modifier = Modifier.width(132.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Spacer(Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.clock_icon),
                    contentDescription = stringResource(R.string.clock_icon)
                )

                Spacer(Modifier.width(2.dp))

                Text(
                    text = item[3],
                    fontFamily = rubikFamily,
                    fontSize = 16.sp,
                )
            }

            Spacer(Modifier.height(13.dp))
        }
    }
}

@Composable
private fun InterestingSection() {
    val list = listOf(
        R.drawable.get_pen to "Получи ручку в подарок",
        R.drawable.calculator to "Калькуляторы - зло!",
        R.drawable.get_pen to "Получи конфеты в подарок",
    )

    ScrollableContent(
        stringResource(R.string.interesting),
        openAllAction = { /*TODO*/ }) {
        for (item in list)
            ClickableImageWithText(item)
    }
}

@Composable
private fun PromotionsSection() {
    val list = listOf(
        R.drawable.presents_from_attache to "Attache несёт радость!",
        R.drawable.calculator to "2 калькулятора\nпо цене 1"
    )

    ScrollableContent(
        stringResource(R.string.promotions),
        openAllAction = { /*TODO*/ },
    ) {
        for (item in list)
            ClickableImageWithText(item)
    }
}

@Composable
private fun ScrollableContent(
    text: String,
    openAllAction: () -> Unit,
    scrollableItems: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
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
private fun ClickableImageWithText(item: Pair<Int, String>) {
    Column(modifier = Modifier.padding(start = 10.dp)) {
        Image(
            modifier = Modifier
                .size(width = 248.dp, height = 126.dp)
                .clip(RoundedCornerShape(10))
                .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10))
                .clickable { /*TODO*/ },
            painter = painterResource(item.first),
            contentDescription = item.second
        )

        Spacer(Modifier.height(3.dp))

        Text(
            text = item.second,
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
            modifier = Modifier.align(Alignment.CenterStart),
            onClick = onClick
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
private fun BonusCardSection() {
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
                        append("100") // TODO
                    }
                }

            },
            modifier = Modifier.align(Alignment.BottomStart)
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
                painter = painterResource(R.drawable.qr_code), // TODO
                contentDescription = stringResource(
                    R.string.qr_code
                )
            )
        }
    }
}

@Composable
private fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 27.dp, end = 12.dp),
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterStart),
            text = stringResource(R.string.hello) + "Роман" + "!",
            fontFamily = rubikOneFamily,
            fontSize = 20.sp,
            color = Color.Black
        )

        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { /*TODO*/ }) {
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(R.drawable.notification_icon),
                contentDescription = stringResource(
                    R.string.notifications
                )
            )
        }
    }
}

@Composable
private fun Background(parentSize: IntSize) {
    val density = LocalDensity.current

    CircleCanvas(
        modifier = Modifier.fillMaxSize(),
        width = 0.21f,
        height = 0.5f,
        radius = 0.25f
    )

    CircleCanvas(
        modifier = Modifier.fillMaxSize(),
        width = 1.06f,
        height = 0.75f,
        radius = 0.2f
    )

    Image(
        modifier = Modifier
            .graphicsLayer {
                translationX = parentSize.width * 0.8f
                translationY = parentSize.height * 0.13f
                scaleX = parentSize.width * 0.3f / with(density) { 100.dp.toPx() }
                scaleY = parentSize.height * 0.15f / with(density) { 100.dp.toPx() }
            }
            .size(100.dp),
        painter = painterResource(R.drawable.rounded_triangle),
        contentDescription = stringResource(
            R.string.rounded_triangle
        )
    )
}


