package sk.o2.android.figura.rado.assignement.password.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import sk.o2.android.figura.rado.assignement.password.R

val FontFontFamily = FontFamily(
    Font(R.font.inter_variable_font),
)

val FontLabelMSize = TextUnit(16f, TextUnitType.Sp)
val FontLabelSSize = TextUnit(14f, TextUnitType.Sp)
val FontBodyMSize = TextUnit(16f, TextUnitType.Sp)

val FontLabelMWeight = FontWeight(500)
val FontLabelSWeight = FontWeight(550)
val FontBodyMWeight = FontWeight(400)

val FontLabelMLineHeight = TextUnit(22f, TextUnitType.Sp)
val FontLabelSLineHeight = TextUnit(17f, TextUnitType.Sp)
val FontBodyMLineHeight = TextUnit(22f, TextUnitType.Sp)

val FontLabelMLetterSpc = TextUnit(0.16f, TextUnitType.Sp)
val FontLabelSLetterSpc = TextUnit(0.16f, TextUnitType.Sp)
val FontBodyMLetterSpc = TextUnit(0.01f, TextUnitType.Sp)

val FontLabelM = TextStyle (
    fontFamily = FontFontFamily,
    fontSize = FontLabelMSize,
    fontWeight = FontLabelMWeight,
    lineHeight = FontLabelMLineHeight,
    letterSpacing = FontLabelMLetterSpc
)

val FontLabelS = TextStyle (
    fontFamily = FontFontFamily,
    fontSize = FontLabelSSize,
    fontWeight = FontLabelSWeight,
    lineHeight = FontLabelSLineHeight,
    letterSpacing = FontLabelSLetterSpc
)

val FontBodyM = TextStyle (
    fontFamily = FontFontFamily,
    fontSize = FontBodyMSize,
    fontWeight = FontBodyMWeight,
    lineHeight = FontBodyMLineHeight,
    letterSpacing = FontBodyMLetterSpc,
)


// Set of Material typography styles to start with
val Typography = Typography(
    labelMedium = FontLabelM,
    labelSmall = FontLabelS,
    bodyMedium = FontBodyM,
)