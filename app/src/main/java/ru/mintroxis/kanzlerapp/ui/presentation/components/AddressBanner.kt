package ru.mintroxis.kanzlerapp.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import ru.mintroxis.kanzlerapp.ui.theme.Lime
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Composable
fun AddressBanner(item: Array<String>) {
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