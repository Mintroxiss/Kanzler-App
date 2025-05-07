package ru.mintroxis.kanzlerapp.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owlbuddy.www.countrycodechooser.CountryCodeChooser
import com.owlbuddy.www.countrycodechooser.utils.enums.CountryCodeType
import ru.mintroxis.kanzlerapp.R
import ru.mintroxis.kanzlerapp.presentation.components.BrightButton
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
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()

        MainScaffold {
            HeaderSection()

            Spacer(modifier = Modifier.height(10.dp))

            InputSection()

            Spacer(modifier = Modifier.height(35.dp))

            SelectionSection()

            Spacer(modifier = Modifier.height(35.dp))

            NextSection()

            Spacer(modifier = Modifier.height(35.dp))
        }
    }
}

@Composable
private fun HeaderSection() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(start = 18.dp, end = 18.dp)) {
        IconButton(
            modifier = Modifier
                .size(36.dp)
                .align(Alignment.BottomStart),

            onClick = { /*TODO*/ },
            content = {
                Image(
                    modifier = Modifier.fillMaxSize(),

                    painter = painterResource(id = R.drawable.go_back_icon),
                    contentDescription = stringResource(R.string.go_back),
                )
            }
        )

        Text(
            modifier = Modifier.align(Alignment.TopCenter),
            text = stringResource(R.string.registration),
            fontFamily = rubikFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun NextSection() {
    var loyaltyProgram by remember { mutableStateOf(false) }
    var personalData by remember { mutableStateOf(false) }
    var messages by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AcceptCheckbox(
            simpleText = stringResource(R.string.i_agree_with_the_rules),
            linkText = stringResource(R.string.of_the_loyalty_program),
            link = stringResource(R.string.loyalty_program_link), // TODO
            checked = loyaltyProgram,
            onCheckedChange = { loyaltyProgram = !loyaltyProgram }
        )

        AcceptCheckbox(
            simpleText = stringResource(R.string.i_give_my_consent_to),
            linkText = stringResource(R.string.the_processing_of_personal_data),
            link = stringResource(R.string.personal_data_link), // TODO
            checked = personalData,
            onCheckedChange = { personalData = !personalData }
        )

        AcceptCheckbox(
            simpleText = "Хочу получать SMS-рассылку",
            checked = messages,
            onCheckedChange = { messages = !messages }
        )

        BrightButton(stringResource(R.string.next)) { }
    }
}

@Composable
private fun AcceptCheckbox(
    simpleText: String,
    linkText: String = "",
    link: String = "",
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked, onCheckedChange = onCheckedChange, colors = CheckboxDefaults.colors(
                checkedColor = DeepRed,
                uncheckedColor = DeepRed,
                checkmarkColor = White,
            )
        )

        val annotatedText = buildAnnotatedString {
            append(simpleText)

            pushStringAnnotation(tag = "URL", annotation = link)
            withStyle(
                style = SpanStyle(
                    color = DeepRed,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(linkText)
            }
        }

        val uriHandler = LocalUriHandler.current
        ClickableText(
            text = annotatedText,
            style = TextStyle(
                fontFamily = rubikFamily,
                fontSize = 14.sp
            ),
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        uriHandler.openUri(annotation.item)
                    }
            }
        )
    }

}

@Composable
private fun SelectionSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetBirthday()
        Spacer(modifier = Modifier.height(15.dp))
        SetGender()
    }
}

enum class Gender {
    MALE, FEMALE
}

@Composable
private fun SetGender() {
    var selectedGender by remember { mutableStateOf<Gender?>(null) }

    SubtitleText(stringResource(R.string.gender))

    Spacer(modifier = Modifier.height(14.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        GenderOption(
            text = stringResource(R.string.male),
            icon = ImageVector.vectorResource(id = R.drawable.male_icon),
            selected = selectedGender == Gender.MALE,
            contentDescription = stringResource(R.string.man_icon),
        ) {
            selectedGender = Gender.MALE
        }

        GenderOption(
            text = stringResource(R.string.female),
            icon = ImageVector.vectorResource(id = R.drawable.female_icon),
            selected = selectedGender == Gender.FEMALE,
            contentDescription = stringResource(R.string.icon_with_woman),
        ) {
            selectedGender = Gender.FEMALE
        }
    }
}


@Composable
fun GenderOption(
    text: String,
    icon: ImageVector,
    selected: Boolean,
    contentDescription: String,
    onSelect: () -> Unit,
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Red,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onSelect() }
            .background(if (selected) AlternativeWhite else White)
            .padding(horizontal = 12.dp, vertical = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RadioButton(
                modifier = Modifier.scale(0.6f),
                selected = selected,
                onClick = null,
                colors = RadioButtonDefaults.colors(
                    selectedColor = DeepRed,
                    unselectedColor = Color.Black
                )
            )

            Text(text = text, fontSize = 14.sp)

            Icon(modifier = Modifier.size(28.dp), imageVector = icon, contentDescription = contentDescription)
        }
    }
}


@Composable
private fun SetBirthday() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubtitleText(stringResource(R.string.date_of_birth))

        Spacer(modifier = Modifier.height(14.dp))

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
private fun SubtitleText(text: String) {
    Text(
        text = text,
        fontFamily = rubikFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
    )
}

@Composable
private fun ChooseYearOfBirth() {
    val years = (2025 downTo 1925).toList().map { it.toString() }
    val startText = stringResource(R.string.year)
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
                    unfocusedContainerColor = White,
                    focusedContainerColor = AlternativeWhite,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(14.dp),
                textStyle = TextStyle(
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
            Text(
                text = stringResource(R.string.name),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
            )
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
            Text(
                text = stringResource(R.string.surname),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
            )
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
