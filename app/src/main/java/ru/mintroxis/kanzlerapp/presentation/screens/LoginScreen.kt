package ru.mintroxis.kanzlerapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owlbuddy.www.countrycodechooser.CountryCodeChooser
import com.owlbuddy.www.countrycodechooser.utils.enums.CountryCodeType
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.BrightButton
import ru.mintroxis.kanzlerapp.presentation.components.InfoIconButton
import ru.mintroxis.kanzlerapp.presentation.utils.NanpVisualTransformation
import ru.mintroxis.kanzlerapp.presentation.utils.authTextFieldArgs
import ru.mintroxis.kanzlerapp.ui.theme.AlternativeWhite
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        Scaffold(
            modifier = Modifier
                .safeDrawingPadding()
                .fillMaxSize(),
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                HeaderSection()
                Spacer(modifier = Modifier.weight(1f))
                InputSection()
                Spacer(modifier = Modifier.weight(1f))
                FooterSection()
                Spacer(modifier = Modifier.weight(0.25f))
            }
        }
    }

}

@Composable
private fun BackgroundImage() {
    Image(
        modifier = Modifier.fillMaxSize(),

        painter = painterResource(id = R.drawable.pen_background),
        contentDescription = "pen_background",

        contentScale = ContentScale.Crop
    )
}

@Composable
private fun FooterSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),

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

        border = BorderStroke(width = 2.dp, color = DeepRed),
        colors = ButtonDefaults.buttonColors(containerColor = AlternativeWhite),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Text(
            modifier = Modifier,

            text = stringResource(id = R.string.reg_button),
            color = Color.Black,
            fontSize = 17.sp,
        )
    }
}

@Composable
private fun InputSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PhoneNumberTextField()
        PasswordTextField()
        PasswordInfoText()
        BrightButton(text = stringResource(id = R.string.authorisation), action = { /*TODO*/ })
        ForgetPasswordButton()
    }
}

@Composable
private fun HeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),

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
    )
}

@Composable
private fun ForgetPasswordButton() {
    TextButton(modifier = Modifier.padding(top = 6.dp),

        onClick = { /*TODO*/ }) {
        Text(
            modifier = Modifier,

            text = stringResource(id = R.string.forget_password),
            color = DeepRed,
            fontSize = 17.sp,
            textDecoration = TextDecoration.Underline
        )
    }

}


@Composable
private fun PasswordInfoText() {
    Text(
        modifier = Modifier,

        text = stringResource(id = R.string.password_info),
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        lineHeight = 13.sp,
    )
}

@Composable
private fun textFieldColorsForAuthTextField(): TextFieldColors = TextFieldDefaults.colors(
    focusedContainerColor = AlternativeWhite,
    unfocusedContainerColor = AlternativeWhite,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    cursorColor = Color.Black,
)

@Composable
private fun PhoneNumberTextField() {
    var phoneNumber by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("996") }

    val numericRegex = Regex("[^0-9]")

    TextField(
        modifier = Modifier.authTextFieldArgs(),

        value = phoneNumber,
        onValueChange = {
            val stripped = numericRegex.replace(it, "")
            phoneNumber = if (stripped.length >= 10) {
                stripped.substring(0..9)
            } else {
                stripped
            }
        },

        colors = textFieldColorsForAuthTextField(),
        shape = RoundedCornerShape(14.dp),
        visualTransformation = NanpVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        textStyle = TextStyle(
            fontSize = 17.sp, fontFamily = rubikFamily, fontWeight = FontWeight.SemiBold
        ),
        singleLine = true,
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CountryCodeChooser(modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp, shape = RoundedCornerShape(14.dp), color = DeepRed
                    ),
                    textStyle = TextStyle(
                        fontFamily = rubikFamily, fontSize = 17.sp, fontWeight = FontWeight.Normal
                    ),
                    defaultCountry = "KG",
                    countryCodeType = CountryCodeType.FLAG,
                    onCountySelected = { countryCodeWithoutPrefix, _, _ ->
                        countryCode = countryCodeWithoutPrefix
                    })
                Text(
                    modifier = Modifier.padding(start = 6.dp),

                    text = "+$countryCode",

                    fontFamily = rubikFamily,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }
        },
    )
}

@Composable
private fun PasswordTextField() {
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

@Composable
private fun LogoImage() {
    Image(
        modifier = Modifier.size(width = 320.dp, height = 150.dp),

        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo_description)
    )
}

@Composable
private fun InfoIconBox() {
    Box(
        modifier = Modifier.fillMaxWidth(),

        contentAlignment = Alignment.CenterEnd
    ) {
        InfoIconButton()
    }
}

