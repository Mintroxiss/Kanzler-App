package ru.mintroxis.kanzlerapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owlbuddy.www.countrycodechooser.CountryCodeChooser
import com.owlbuddy.www.countrycodechooser.utils.enums.CountryCodeType
import ru.mintroxis.kanzlerapp.presentation.utils.NanpVisualTransformation
import ru.mintroxis.kanzlerapp.ui.theme.Red
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview
@Composable
fun PhoneNumberTextField() {
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
                        width = 1.dp, shape = RoundedCornerShape(14.dp), color = Red
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