package com.example.workouter.model

import com.google.firebase.firestore.DocumentId
import java.util.*

data class NewTraining(
    @DocumentId val id: String,
    var date: Date,
) {
    companion object {
        fun createNew(): NewTraining {
            return NewTraining(
                id=UUID.randomUUID().toString(),
                date=Date()
            )
        }
    }
}
