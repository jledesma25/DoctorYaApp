package com.jotadev.doctoryaapp.presentation.on_boarding.data

import androidx.annotation.DrawableRes
import com.jotadev.doctoryaapp.R

data class OnBoardingPage(
    @DrawableRes val image:Int,
    val title:String,
    val description:String
)

fun getDataOnboarding() : List<OnBoardingPage>{

    return listOf(
        OnBoardingPage(
            image = R.drawable.image1,
            title = "Greetings",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's"
        ),
        OnBoardingPage(
            image = R.drawable.image2,
            title = "Explore",
            description = "of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into"
        ),
        OnBoardingPage(
            image = R.drawable.image3,
            title = "Power",
            description = "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing"
        )
    )

}