package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.presentation.components.AddressBanner
import ru.mintroxis.kanzlerapp.ui.presentation.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.Grey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkWhite)
    ) {
        MainScreenColumn {
            InfoElement()

            Spacer(modifier = Modifier.height(10.dp))

            BeneficialInformationElement()

            Spacer(modifier = Modifier.size(18.dp))

            MenuSection()

            Spacer(modifier = Modifier.height(12.dp))

            AddressesSection()

            Spacer(modifier = Modifier.height(12.dp))

            MenuElement(
                { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                painter = painterResource(R.drawable.logout_icon),
                contentDescription = stringResource(R.string.logout_icon),
                text = stringResource(R.string.logout)
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

    ScrollableContent {
        for (item in list) {
            AddressBanner(item)
        }
    }
}

@Composable
private fun ScrollableContent(scrollableItems: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.width(15.dp))

            scrollableItems()

            Spacer(modifier = Modifier.width(24.dp))
        }
    }
}

@Composable
private fun MenuSection() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val lambdas = listOf(
            { /*TODO*/ },
            { /*TODO*/ },
            { /*TODO*/ },
            { /*TODO*/ },
            { /*TODO*/ }
        )
        val icons = listOf(
            R.drawable.purchase_history_icon,
            R.drawable.settings_icon,
            R.drawable.notifications_icon,
            R.drawable.bonus_program_icon,
            R.drawable.support_icon
        )
        val contentDescriptions = listOf(
            stringResource(R.string.purchase_history_icon),
            stringResource(R.string.settings_icon),
            stringResource(R.string.notifications_icon),
            stringResource(R.string.bonus_program_icon),
            stringResource(R.string.support_icon),
        )
        val texts = listOf(
            stringResource(R.string.purchase_history),
            stringResource(R.string.settings),
            stringResource(R.string.notifications),
            stringResource(R.string.bonus_program),
            stringResource(R.string.support)
        )

        var i = 0
        repeat(5) {
            when (i) {
                0 -> {
                    MenuElement(
                        onClick = lambdas[i],
                        shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp),
                        painter = painterResource(icons[i]),
                        contentDescription = contentDescriptions[i],
                        text = texts[i]
                    )

                    HorizontalDivider(modifier = Modifier.width(362.dp))
                }

                4 -> {
                    MenuElement(
                        onClick = lambdas[i],
                        shape = RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp),
                        painter = painterResource(icons[i]),
                        contentDescription = contentDescriptions[i],
                        text = texts[i]
                    )
                }

                else -> {
                    MenuElement(
                        onClick = lambdas[i],
                        shape = RectangleShape,
                        painter = painterResource(icons[i]),
                        contentDescription = contentDescriptions[i],
                        text = texts[i]
                    )

                    HorizontalDivider(modifier = Modifier.width(362.dp))
                }
            }
            i++
        }
    }
}

@Composable
private fun MenuElement(
    onClick: () -> Unit,
    shape: Shape,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    Button(
        modifier = Modifier.width(362.dp),
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painter,
                    contentDescription = contentDescription
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = text,
                    fontFamily = rubikFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }

            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(R.drawable.open_icon),
                contentDescription = stringResource(R.string.open_icon)
            )
        }
    }
}

@Composable
private fun BeneficialInformationElement() {
    Box(
        modifier = Modifier
            .size(width = 362.dp, height = 56.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "150",
                    fontFamily = rubikFamily,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Red
                )

                Text(text = "бонусов", fontFamily = rubikFamily, fontSize = 11.sp)
            }

            Spacer(modifier = Modifier.width(25.dp))

            VerticalDivider(
                modifier = Modifier.height(48.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(25.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "5%",
                    fontFamily = rubikFamily,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Red
                )

                Text(text = "скидка", fontFamily = rubikFamily, fontSize = 11.sp)
            }
        }
    }
}

@Composable
private fun InfoElement() {
    Box(
        modifier = Modifier
            .size(width = 362.dp, height = 68.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White)
            .padding(start = 18.dp, end = 18.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Column {
            Text(
                text = "Василий Петров",
                fontFamily = rubikFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "+996 (555)-77-66-55",
                fontFamily = rubikFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = Grey
            )
        }
    }
}