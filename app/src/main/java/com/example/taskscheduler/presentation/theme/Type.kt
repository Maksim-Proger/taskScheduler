package com.example.taskscheduler.presentation.theme

import com.example.taskscheduler.R
import androidx.compose.ui.text.font.Font
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val mainFontFamily = FontFamily(Font(R.font.jetbrains_mono_medium_italic))

val Typography = Typography(

    bodySmall = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 27.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)