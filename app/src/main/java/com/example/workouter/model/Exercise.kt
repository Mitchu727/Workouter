package com.example.workouter.model
import com.google.firebase.firestore.DocumentId
import java.util.UUID

data class Exercise (
    @DocumentId val id: String = "defaultId",
    val name: String = "",
//    val description: String = "",
) {
    companion object {
        fun generateRandomUUID(): String {
            return UUID.randomUUID().toString()
        }
    }
}