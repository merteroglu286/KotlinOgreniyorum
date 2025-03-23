package com.merteroglu286.kotlinogreniyorum.presentation.screen.topic

import com.merteroglu286.kotlinogreniyorum.domain.model.Topic

val fakeTopicList = listOf(
    Topic(
        id = 1,
        title = "Introduction to Kotlin",
        moduleId = 101,
        content = listOf(
            "Kotlin is a statically typed programming language.",
            "It is fully interoperable with Java.",
            "Kotlin is concise and expressive."
        ),
        examples = listOf(
            "fun main() { println(\"Hello, World!\") }",
            "val name: String = \"Kotlin\""
        )
    ),
    Topic(
        id = 2,
        title = "Functions in Kotlin",
        moduleId = 102,
        content = listOf(
            "Functions are declared using the 'fun' keyword.",
            "Functions can have default arguments.",
            "Functions can be extension functions."
        ),
        examples = listOf(
            "fun greet(name: String) { println(\"Hello, \$name\") }",
            "fun Int.isEven(): Boolean = this % 2 == 0"
        )
    ),
    Topic(
        id = 3,
        title = "Data Classes in Kotlin",
        moduleId = 103,
        content = listOf(
            "Data classes are used to hold data.",
            "They automatically generate toString(), equals(), and hashCode() methods.",
            "Data classes can be destructured."
        ),
        examples = listOf(
            "data class User(val name: String, val age: Int)",
            "val user = User(\"Alice\", 30)"
        )
    ),
    Topic(
        id = 4,
        title = "Null Safety in Kotlin",
        moduleId = 104,
        content = listOf(
            "Kotlin has built-in null safety.",
            "The '?' operator is used to declare nullable types.",
            "The '!!' operator is used to assert non-null values."
        ),
        examples = listOf(
            "val name: String? = null",
            "val length = name?.length ?: 0"
        )
    ),
    Topic(
        id = 5,
        title = "Collections in Kotlin",
        moduleId = 105,
        content = listOf(
            "Kotlin provides a rich set of collection operations.",
            "Collections are immutable by default.",
            "Common collections include List, Set, and Map."
        ),
        examples = listOf(
            "val numbers = listOf(1, 2, 3, 4, 5)",
            "val squares = numbers.map { it * it }"
        )
    )
)