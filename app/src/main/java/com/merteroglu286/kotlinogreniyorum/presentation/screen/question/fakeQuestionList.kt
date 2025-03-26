package com.merteroglu286.kotlinogreniyorum.presentation.screen.question

import com.merteroglu286.kotlinogreniyorum.domain.model.Question

val fakeQuestionList = listOf(
    Question(
        id = 1,
        moduleId = 101,
        questionText = "Kotlin'de 'val' ve 'var' anahtar kelimeleri arasındaki fark nedir?",
        options = listOf(
            "'val' değişkeni immutable (değiştirilemez) yapar, 'var' değişkeni mutable (değiştirilebilir) yapar.",
            "'val' değişkeni mutable (değiştirilebilir) yapar, 'var' değişkeni immutable (değiştirilemez) yapar.",
            "'val' ve 'var' arasında hiçbir fark yoktur.",
            "'val' sadece fonksiyonlarda kullanılır, 'var' sadece sınıflarda kullanılır."
        ),
        correctAnswerIndex = 0
    ),
    Question(
        id = 2,
        moduleId = 101,
        questionText = "Kotlin'de 'null' değerlerle nasıl başa çıkılır?",
        options = listOf(
            "'!!' operatörü kullanılarak",
            "'?' operatörü kullanılarak",
            "'null' değerler Kotlin'de desteklenmez.",
            "'if-else' blokları kullanılarak"
        ),
        correctAnswerIndex = 1
    ),
    Question(
        id = 3,
        moduleId = 102,
        questionText = "Kotlin'de bir data class'ın özellikleri nelerdir?",
        options = listOf(
            "Otomatik olarak 'equals', 'hashCode', 'toString' ve 'copy' metodlarını sağlar.",
            "Sadece 'toString' metodunu otomatik olarak sağlar.",
            "Data class'lar Kotlin'de desteklenmez.",
            "Data class'lar sadece immutable (değiştirilemez) özelliklere sahip olabilir."
        ),
        correctAnswerIndex = 0
    ),
    Question(
        id = 4,
        moduleId = 102,
        questionText = "Kotlin'de 'when' ifadesi ne işe yarar?",
        options = listOf(
            "Java'daki 'switch' ifadesine benzer, ancak daha güçlüdür.",
            "Sadece sayısal değerlerle çalışır.",
            "Kotlin'de 'when' ifadesi yoktur.",
            "Sadece string değerlerle çalışır."
        ),
        correctAnswerIndex = 0
    )
)