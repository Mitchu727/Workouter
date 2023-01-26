package com.example.workouter.model

import com.google.firebase.firestore.DocumentId
import java.util.UUID

data class TrainingPart(
    @DocumentId val id: String,
    val repsCount: Int,
    val trainingId: String,
    val exerciseId: String
) {
    companion object {
        fun generateRandomUUID(): String {
            return UUID.randomUUID().toString()
        }
    }
}