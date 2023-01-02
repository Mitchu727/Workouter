package com.example.workouter.domain

data class Exercise(
    var name: String,
    val type: ExerciseType,
    val Series: Int = 1
)

enum class ExerciseType {
    TIMED,
    COUNTED
}