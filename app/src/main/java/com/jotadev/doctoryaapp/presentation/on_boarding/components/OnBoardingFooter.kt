package com.jotadev.doctoryaapp.presentation.on_boarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jotadev.doctoryaapp.ui.theme.DisableDot
import com.jotadev.doctoryaapp.ui.theme.PrimaryColor

@Composable
fun OnBoardingFooter(
    modifier: Modifier = Modifier,
    counterPager:Int,
    pagerState:PagerState
) {
    repeat(counterPager){ iteration ->
        val color = if(pagerState.currentPage == iteration) PrimaryColor else DisableDot
        Box(
            modifier = modifier
                .padding(2.dp)
                .clip(CircleShape)
                .background(color)
                .size(12.dp)
        )
    }
}