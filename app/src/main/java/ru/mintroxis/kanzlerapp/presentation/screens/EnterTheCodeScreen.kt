package ru.mintroxis.kanzlerapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.BackIconButton
import ru.mintroxis.kanzlerapp.presentation.components.BrightButton
import ru.mintroxis.kanzlerapp.presentation.components.InfoIconButton
import ru.mintroxis.kanzlerapp.presentation.components.LogoImage
import ru.mintroxis.kanzlerapp.presentation.components.MainScaffold
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.LightGrey
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun EnterTheCodeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MainScaffold {
            HeaderSection()

            InputSection()
        }
    }
}

@Composable
private fun InputSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(R.string.enter_the_code_from_sms))

        VerificationCodeInput { /*TODO*/ }

        BrightButton(text = stringResource(R.string.confirm)) { /*TODO*/ }

        TextButton(modifier = Modifier.padding(top = 6.dp), onClick = { /*TODO*/ }) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.resend),
                color = DeepRed,
                fontSize = 16.sp,
                fontFamily = rubikFamily
            )
        }
    }

}

@Composable
fun VerificationCodeInput(onCodeComplete: (String) -> Unit) {
    val codeLength = 4

    var code by remember { mutableStateOf(List(codeLength) { "" }) }
    val focusRequesters = List(codeLength) { FocusRequester() }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        code.forEachIndexed { index, char ->
            OutlinedTextField(
                modifier = Modifier
                    .width(55.dp)
                    .height(60.dp)
                    .focusRequester(focusRequesters[index]),
                value = char,
                onValueChange = { value ->
                    if (value.length <= 1 && value.all { it.isDigit() }) {
                        code = code.toMutableList().also { it[index] = value }
                        if (value.isNotEmpty() && index < codeLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                        if (code.all { it.isNotEmpty() }) {
                            onCodeComplete(code.joinToString(""))
                        }
                    }
                },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontFamily = rubikFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrey,
                    focusedContainerColor = LightGrey,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = DeepRed,
                    cursorColor = DeepRed
                ),
                shape = RoundedCornerShape(10.dp)
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
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
                text = stringResource(R.string.enter_the_code),
                fontFamily = rubikFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            BackIconButton { /*TODO()*/ }

            InfoIconButton(Modifier.align(Alignment.BottomEnd)) { /*TODO*/ }
        }
        LogoImage()
    }
}