package ru.mintroxis.kanzlerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.domain.ContentBanner
import ru.mintroxis.kanzlerapp.ui.theme.Grey

@Composable
fun BannerElement(modifier: Modifier = Modifier, clickable: () -> Unit, item: ContentBanner) {
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(10))
            .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10))
            .clickable { clickable() },
        painter = painterResource(item.imageID),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun BannerElementPreview() {
    BannerElement(
        item = ContentBanner(
            imageID = R.drawable.get_pen,
            title = "",
            text = "",
            date = ""
        ),
        clickable = {  }
    )
}