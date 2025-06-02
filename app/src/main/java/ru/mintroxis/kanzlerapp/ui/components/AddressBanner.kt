package ru.mintroxis.kanzlerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.AddressBanner
import ru.mintroxis.kanzlerapp.ui.theme.Lime
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Composable
fun AddressBanner(modifier: Modifier = Modifier, item: AddressBanner, contentScale: Int = 15) {
    Box(
        modifier = modifier
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
            Spacer(Modifier.weight(13f))

            Text(
                text = item.street,
                fontFamily = rubikFamily,
                fontSize = contentScale.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.weight(2f))

            Text(
                text = item.address,
                fontFamily = rubikFamily,
                fontSize = (contentScale - 2).sp,
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = item.phone,
                fontFamily = rubikFamily,
                fontSize = (contentScale - 4).sp,
            )

            Spacer(Modifier.weight(6f))

            HorizontalDivider(
                modifier = Modifier
                    .padding(start = 42.dp, end = 42.dp)
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )

            Spacer(Modifier.weight(6f))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size((contentScale + 5).dp),
                    painter = painterResource(R.drawable.clock_icon),
                    contentDescription = stringResource(R.string.clock_icon)
                )

                Spacer(Modifier.width(2.dp))

                Text(
                    text = item.openingHours,
                    fontFamily = rubikFamily,
                    fontSize = (contentScale + 1).sp,
                )
            }

            Spacer(Modifier.weight(13f))
        }
    }
}