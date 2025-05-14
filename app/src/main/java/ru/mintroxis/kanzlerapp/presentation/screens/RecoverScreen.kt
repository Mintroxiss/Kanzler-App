package ru.mintroxis.kanzlerapp.presentation.screens

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.BackIconButton
import ru.mintroxis.kanzlerapp.presentation.components.BrightButton
import ru.mintroxis.kanzlerapp.presentation.components.InfoIconButton
import ru.mintroxis.kanzlerapp.presentation.components.LogoImage
import ru.mintroxis.kanzlerapp.presentation.components.MainScaffold
import ru.mintroxis.kanzlerapp.presentation.components.PasswordInfoText
import ru.mintroxis.kanzlerapp.presentation.components.PasswordTextField
import ru.mintroxis.kanzlerapp.presentation.components.PhoneNumberTextField
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

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

        MainScaffold {
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
                fontFamily = rubikFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
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
