package com.example.workouter.model

import com.example.workouter.DEFAULT_TRAINING_ID
import com.google.firebase.firestore.DocumentId
import java.util.UUID
import java.util.Date

data class Training(
    @DocumentId val id: String = DEFAULT_TRAINING_ID,
    val date: Date = Date(2023, 1, 1)
) {
    companion object {
        fun createNew(): Training {
            return Training(
                id=UUID.randomUUID().toString(),
                date=Date()
            )
        }
    }
}
