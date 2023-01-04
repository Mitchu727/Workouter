package com.example.workouter.domain

data class Exercise(
    var name: String,
    var type: ExerciseType,
    var series: Int = 1
)

enum class ExerciseType {
    TIMED,
    COUNTED
}