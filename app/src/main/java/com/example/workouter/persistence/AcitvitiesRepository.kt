package com.example.workouter.persistence

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

interface ActivitiesRepository {

    fun insert(activities: List<String>)

    fun getAll(): List<String>

}

class FirebaseActivitiesRepository: ActivitiesRepository {
    val db = Firebase.firestore

    override fun insert(activities: List<String>) {
        print("Inserting to database: ${activities}")
    }

    override fun getAll(): List<String> {
        val activities: MutableList<String> = mutableListOf()
        db.collection("activities")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    activities.add(document.data["name"].toString())
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
        Log.d(TAG, "In function activities: ${activities}")
        return activities
    }
}