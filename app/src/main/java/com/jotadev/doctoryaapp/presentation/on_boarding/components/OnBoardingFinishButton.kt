package com.jotadev.doctoryaapp.presentation.on_boarding.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingFinishButton(
    modifier: Modifier = Modifier,
    counterPager:Int,
    pagerState:PagerState,
    onClick:()->Unit
) {
    AnimatedVisibility(
        visible = pagerState.currentPage == counterPager - 1
    ) {
        OutlinedButton(
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 32.dp),
            onClick = {
                onClick()
            }
        ) {
            Text(text = "Empezar")
        }
    }
}