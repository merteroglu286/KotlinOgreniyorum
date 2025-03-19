package com.merteroglu286.kotlinogreniyorum.domain.model

import androidx.annotation.DrawableRes
import com.merteroglu286.kotlinogreniyorum.R

sealed class OnboardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    data object First : OnboardingPage(
        image = R.drawable.ic_programming,
        title = "Kotlin'e Başla",
        description = "Kotlin, modern ve güçlü bir dil. Bu uygulama ile temelleri öğrenerek programlamaya adım at."
    )
    data object Second : OnboardingPage(
        image = R.drawable.ic_learn,
        title = "Etkileşimli Öğren",
        description = "Kod örnekleri ve interaktif içeriklerle temel programlama kavramlarını öğren."
    )
    data object Third : OnboardingPage(
        image = R.drawable.ic_question,
        title = "Kendini Test Et",
        description = "Testler ve alıştırmalarla bilgini sınayarak gelişimini takip et."
    )
}
