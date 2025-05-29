package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.theme.DarkWhite
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun QRScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkWhite),
        contentAlignment = Alignment.Center
    ) {
        QRCodeSection()
    }
}

@Composable
private fun QRCodeSection() {
    Column(
        modifier = Modifier
            .size(288.dp, 402.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightGrey),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.width(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BeneficialInfoText(numText = "5%", descrText = "скидка")

            BeneficialInfoText(numText = "150", descrText = "бонусов")
        }

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(R.drawable.qr_code),
                contentDescription = stringResource(R.string.qr_code)
            )
        }

        Text(
            text = "Покажите этот код при оплате\n" +
                    "для списания или начисления\n" +
                    "бонусов",
            fontFamily = rubikFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )

        TextButton(modifier = Modifier.padding(top = 6.dp), onClick = { /*TODO*/ }) {
            Text(
                modifier = Modifier,

                text = stringResource(R.string.accrual_rules),
                color = Red,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
private fun BeneficialInfoText(numText: String, descrText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = numText,
            fontFamily = rubikFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp,
            color = Red
        )

        Text(
            text = descrText,
            fontFamily = rubikFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}