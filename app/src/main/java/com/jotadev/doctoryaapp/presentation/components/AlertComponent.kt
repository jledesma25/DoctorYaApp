package com.jotadev.doctoryaapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.jotadev.doctoryaapp.R
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@Composable
fun AlertComponent(
    modifier: Modifier = Modifier,
    title:String,
    body:String,
    dismiss:()->Unit
) {
    Dialog(
        onDismissRequest = {  },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp,
                    color = PrimaryColor,
                    RoundedCornerShape(8.dp)
                )
                .background(Color.White)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    dismiss()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close"
                )
            }

            TextComponentBasic(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                align = TextAlign.Center
            )
            Image(
                painter = painterResource(R.drawable.icon_alert),
                contentDescription = "Icon Alert",
                modifier = Modifier.size(60.dp)
            )
            TextComponentBasic(
                text = body,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                ),
                align = TextAlign.Center
            )

        }
    }
}