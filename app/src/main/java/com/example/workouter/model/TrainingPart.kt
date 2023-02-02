package com.example.workouter.model

import java.util.Date
import java.util.UUID

data class TrainingPart(
    val id: String = "",
    val repsCount: Int = 0,
    val trainingId: String = "",
    val exerciseId: String = "",
    val date: Date = Date(2023,0,0)
) {
    companion object {
        fun generateRandomUUID(): String {
            return UUID.randomUUID().toString()
        }
    }
}