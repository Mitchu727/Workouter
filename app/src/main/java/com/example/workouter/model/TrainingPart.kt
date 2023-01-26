package com.example.workouter.model

import java.util.UUID

data class TrainingPart(
    val id: String = "",
    val repsCount: Int = 0,
    val trainingId: String = "",
    val exerciseId: String = "",
) {
    companion object {
        fun generateRandomUUID(): String {
            return UUID.randomUUID().toString()
        }
    }
}