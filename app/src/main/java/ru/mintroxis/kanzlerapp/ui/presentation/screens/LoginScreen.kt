package ru.mintroxis.kanzlerapp.ui.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.presentation.components.BrightButton
import ru.mintroxis.kanzlerapp.ui.presentation.components.InfoIconButton
import ru.mintroxis.kanzlerapp.ui.presentation.components.LogoImage
import ru.mintroxis.kanzlerapp.ui.presentation.components.MainScaffold
import ru.mintroxis.kanzlerapp.ui.presentation.components.PasswordInfoText
import ru.mintroxis.kanzlerapp.ui.presentation.components.PasswordTextField
import ru.mintroxis.kanzlerapp.ui.presentation.components.PhoneNumberTextField
import ru.mintroxis.kanzlerapp.ui.theme.AlternativeWhite
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.pen_background),
            contentDescription = stringResource(R.string.background_with_pen),
            contentScale = ContentScale.Crop
        )

        MainScaffold {
            HeaderSection()

            Spacer(modifier = Modifier.weight(1f))

            InputSection()

            Spacer(modifier = Modifier.weight(1f))

            FooterSection()

            Spacer(modifier = Modifier.weight(0.25f))
        }
    }

}

@Composable
private fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        QuestionText()

        RegButton()
    }
}

@Composable
private fun RegButton() {
    OutlinedButton(
        modifier = Modifier.size(
            width = 332.dp, height = 40.dp
        ),
        onClick = { /*TODO*/ },
        border = BorderStroke(width = 2.dp, color = Red),
        colors = ButtonDefaults.buttonColors(containerColor = AlternativeWhite),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Text(
            modifier = Modifier,

            text = stringResource(id = R.string.reg_button),
            color = Color.Black,
            fontSize = 17.sp,
            fontFamily = rubikFamily
        )
    }
}

@Composable
private fun InputSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PhoneNumberTextField()

        PasswordTextField()

        PasswordInfoText()

        BrightButton(text = stringResource(id = R.string.authorisation), onClick = { /*TODO*/ })

        ForgetPasswordButton()
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
        InfoIconBox()

        LogoImage()
    }
}

@Composable
private fun QuestionText() {
    Text(
        text = stringResource(id = R.string.first_session),
        fontSize = 13.sp,
        fontFamily = rubikFamily
    )
}

@Composable
private fun ForgetPasswordButton() {
    TextButton(modifier = Modifier.padding(top = 6.dp), onClick = { /*TODO*/ }) {
        Text(
            modifier = Modifier,

            text = stringResource(id = R.string.forget_password),
            color = Red,
            fontSize = 17.sp,
            textDecoration = TextDecoration.Underline,
            fontFamily = rubikFamily
        )
    }

}



@Composable
private fun InfoIconBox() {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
    ) {
        InfoIconButton(Modifier.padding(end = 6.dp)) {TODO()}
    }
}

