package com.jotadev.doctoryaapp.presentation.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String,
    isLoading: Boolean = false,
    size: TextUnit = 18.sp,
    roundedSize: Dp = 12.dp,
    color: Color = PrimaryColor,
    enabled: Boolean = true,
    onClick:()->Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp),
        contentAlignment = Alignment.Center
    ) {
        if(isLoading){
            CircularProgressIndicator(
                color = PrimaryColor
            )
        }else {
            OutlinedButton(
                onClick = {
                    onClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                //colors = ButtonDefaults.buttonColors(
                //    containerColor = color,
                //    contentColor = Color.White
                //),
                shape = RoundedCornerShape(roundedSize),
                enabled = enabled
            ) {
                Text(
                    text = label,
                    fontSize = size,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    color = Color.Black.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}