package com.jotadev.doctoryaapp.presentation.on_boarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jotadev.doctoryaapp.presentation.on_boarding.components.OnBoardingContent
import com.jotadev.doctoryaapp.presentation.on_boarding.components.OnBoardingFinishButton
import com.jotadev.doctoryaapp.presentation.on_boarding.components.OnBoardingFooter
import com.jotadev.doctoryaapp.presentation.on_boarding.data.getDataOnboarding

@Composable
fun OnBoardingScreen(
    onNavigation: () -> Unit
) {
    val onBoardingList = getDataOnboarding()
    val pagerState = rememberPagerState { onBoardingList.size }


    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            state = pagerState
        ) { page ->
            OnBoardingContent(onBoardingPage = onBoardingList[page])
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            OnBoardingFooter(
                counterPager = onBoardingList.size,
                pagerState = pagerState
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OnBoardingFinishButton(
                counterPager = onBoardingList.size,
                pagerState = pagerState,
                onClick = {
                    onNavigation()
                }
            )
        }


    }

}