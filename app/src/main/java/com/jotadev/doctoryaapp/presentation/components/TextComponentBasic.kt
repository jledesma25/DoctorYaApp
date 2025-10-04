package com.jotadev.doctoryaapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TextComponentBasic(
    modifier: Modifier = Modifier,
    text:String,
    style: TextStyle,
    color: Color = Color.Unspecified,
    textDecoration: TextDecoration = TextDecoration.None,
    align: TextAlign = TextAlign.Unspecified
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color,
        textDecoration = textDecoration,
        textAlign = align
    )
}