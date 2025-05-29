package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.presentation.components.BackIconButton
import ru.mintroxis.kanzlerapp.ui.presentation.components.BrightButton
import ru.mintroxis.kanzlerapp.ui.presentation.components.InfoIconButton
import ru.mintroxis.kanzlerapp.ui.presentation.components.LogoImage
import ru.mintroxis.kanzlerapp.ui.presentation.components.MainScreenColumn
import ru.mintroxis.kanzlerapp.ui.presentation.components.PasswordInfoText
import ru.mintroxis.kanzlerapp.ui.presentation.components.PasswordTextField
import ru.mintroxis.kanzlerapp.ui.presentation.components.PhoneNumberTextField
import ru.mintroxis.kanzlerapp.ui.theme.rubikOneFamily

@Preview
@Composable
fun RecoverScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.recover_background),
            contentDescription = stringResource(R.string.background_with_marker_and_glue),
            contentScale = ContentScale.Crop
        )

        MainScreenColumn {
            HeaderSection()
            AuthSection()
        }
    }
}

@Composable
private fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 18.dp, end = 18.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter),
                text = stringResource(R.string.password_recover),
                fontFamily = rubikOneFamily,
                fontSize = 20.sp,
                color = Color.Black
            )

            BackIconButton { /*TODO()*/ }

            InfoIconButton(Modifier.align(Alignment.BottomEnd)) { TODO() }
        }
        LogoImage()
    }
}

@Composable
private fun AuthSection() {
    Column(
        Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PhoneNumberTextField()

        PasswordTextField()

        PasswordInfoText()

        BrightButton(text = stringResource(id = R.string.next), onClick = { /*TODO*/ })
    }
}
