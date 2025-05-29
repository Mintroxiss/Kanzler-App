package ru.mintroxis.kanzlerapp.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.authTextFieldArgs(),
        value = password,
        onValueChange = { password = it },
        colors = textFieldColorsForAuthTextField(),
        label = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.password),
                textAlign = TextAlign.Center,
            )
        },
        shape = RoundedCornerShape(14.dp),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(
            fontSize = 17.sp, fontFamily = rubikFamily, fontWeight = FontWeight.SemiBold
        ),
        singleLine = true
    )
}