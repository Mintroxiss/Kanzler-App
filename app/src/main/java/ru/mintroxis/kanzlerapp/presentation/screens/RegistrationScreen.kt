package ru.mintroxis.kanzlerapp.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owlbuddy.www.countrycodechooser.CountryCodeChooser
import com.owlbuddy.www.countrycodechooser.utils.enums.CountryCodeType
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.MainScaffold
import ru.mintroxis.kanzlerapp.presentation.utils.NanpVisualTransformation
import ru.mintroxis.kanzlerapp.ui.theme.AlternativeWhite
import ru.mintroxis.kanzlerapp.ui.theme.DeepRed
import ru.mintroxis.kanzlerapp.ui.theme.Grey
import ru.mintroxis.kanzlerapp.ui.theme.TranspRed
import ru.mintroxis.kanzlerapp.ui.theme.White
import ru.mintroxis.kanzlerapp.ui.theme.rubikFamily

@Preview(showBackground = true)
@Composable
fun RegistrationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White), contentAlignment = Alignment.Center
    ) {
        BackgroundImage()
        MainScaffold {
            InputSection()
            SelectionSection()
        }
    }
}

@Composable
private fun SelectionSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)
    ) {
        SetBirthday()
    }
}

@Composable
private fun SetBirthday() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.date_of_birth),
            fontFamily = rubikFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ChooseDayOfBirth()
            ChooseMonthOfBirth()
            ChooseYearOfBirth()
        }
    }
}

@Composable
private fun ChooseYearOfBirth() {
    val years = (2025 downTo 1925).toList().map { it.toString() }
    val startText = "Год"
    var selectedText by remember { mutableStateOf(startText) }

    CustomDropdown(
        value = selectedText,
        onValueChange = { selectedText = it },
        items = years
    )
}

@Composable
private fun ChooseMonthOfBirth() {
    val months = (1..12).toList().map { it.toString() }
    val startText = stringResource(R.string.month)
    var selectedText by remember { mutableStateOf(startText) }

    CustomDropdown(
        value = selectedText,
        onValueChange = { selectedText = it },
        items = months
    )
}

@Composable
private fun ChooseDayOfBirth() {
    val days = (1..31).toList().map { it.toString() }
    val startText = stringResource(R.string.day)
    var selectedText by remember { mutableStateOf(startText) }

    CustomDropdown(
        value = selectedText,
        onValueChange = { selectedText = it },
        items = days
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomDropdown(
    value: String,
    onValueChange: (String) -> Unit,
    items: List<String>,
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        ExposedDropdownMenuBox(
            modifier = Modifier
                .size(100.dp, 48.dp),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .border(
                        width = 1.dp,
                        color = DeepRed,
                        shape = RoundedCornerShape(14.dp)
                    ),
                value = value,
                onValueChange = {},
                readOnly = true,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = AlternativeWhite,
                    focusedContainerColor = AlternativeWhite,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedTextColor = Grey,
                    focusedTextColor = Color.Black,
                ),
                shape = RoundedCornerShape(14.dp),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontFamily = rubikFamily,
                    fontWeight = FontWeight.Normal,
                ),
            )
            ExposedDropdownMenu(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .heightIn(max = 50.dp * 4)
                    .background(color = AlternativeWhite),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item,
                                fontSize = 14.sp,
                                fontFamily = rubikFamily,
                                fontWeight = FontWeight.Normal
                            )
                        },
                        onClick = {
                            onValueChange(item)
                            expanded = false
                        },
                    )
                }
            }
        }
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 5.dp)
        )
    }
}


@Composable
private fun InputSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NumberInputTextField()
        NameInputTextField()
        SurnameInputTextField()
    }
}

@Composable
private fun NameInputTextField() {
    var name by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = name,
        onValueChange = {
            name = it
        },
        colors = textFieldColors(),
        textStyle = textFieldTextStyle(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        label = {
            Text(text = stringResource(R.string.name))
        },
    )
}

@Composable
private fun SurnameInputTextField() {
    var surname by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = surname,
        onValueChange = {
            surname = it
        },
        colors = textFieldColors(),
        textStyle = textFieldTextStyle(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        label = {
            Text(text = stringResource(R.string.surname))
        },
    )
}

@Composable
fun NumberInputTextField() {
    var phoneNumber by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("996") }
    val numericRegex = Regex("[^0-9]")

    TextField(modifier = Modifier.fillMaxWidth(),
        value = phoneNumber,
        onValueChange = {
            val stripped = numericRegex.replace(it, "")
            phoneNumber = if (stripped.length >= 10) {
                stripped.substring(0..9)
            } else {
                stripped
            }
        },
        colors = textFieldColors(),
        textStyle = textFieldTextStyle(),
        visualTransformation = NanpVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CountryCodeChooser(modifier = Modifier.size(40.dp),
                    textStyle = TextStyle(
                        fontFamily = rubikFamily, fontSize = 17.sp, fontWeight = FontWeight.Normal
                    ),
                    defaultCountry = "KG",
                    countryCodeType = CountryCodeType.FLAG,
                    onCountySelected = { countryCodeWithoutPrefix, _, _ ->
                        countryCode = countryCodeWithoutPrefix
                    }
                )
                Text(
                    modifier = Modifier.padding(start = 3.dp),
                    text = "+$countryCode",
                    fontFamily = rubikFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    )
}

private fun textFieldTextStyle(): TextStyle = TextStyle(
    fontSize = 14.sp, fontFamily = rubikFamily, fontWeight = FontWeight.Normal
)

@Composable
private fun textFieldColors(): TextFieldColors = TextFieldDefaults.colors(
    unfocusedContainerColor = Color.Transparent,
    focusedContainerColor = Color.Transparent,
    focusedIndicatorColor = DeepRed,
    unfocusedIndicatorColor = Grey,
    focusedLabelColor = DeepRed,
    unfocusedLabelColor = Grey,
)


@Composable
private fun BackgroundImage() {
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        drawCircle(
            color = TranspRed,
            radius = size.width * 0.3f,
            center = Offset(size.width * 0.9f, size.height * 0.2f)
        )
    }
}
