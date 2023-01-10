package com.example.workouter.model.service.firebase_implementation

import android.content.ContentValues
import android.util.Log
import com.example.workouter.model.Exercise
import com.example.workouter.model.service.trace
import com.example.workouter.model.service.StorageService
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class FirebaseStorageService (
    private val firestore: FirebaseFirestore
): StorageService {

    override val exercises: Flow<List<Exercise>>
        get() = exerciseCollection().snapshots() .map { snapshot -> snapshot.toObjects() }

    override suspend fun getAllExercises(): List<Exercise> =
        exerciseCollection().get().await().toObjects()

    override suspend fun getExercise(exerciseId: String): Exercise? {
        Log.d(ContentValues.TAG, "Request to get exercise with id: $exerciseId")
        return exerciseCollection().document(exerciseId).get().await().toObject()
    }
    override suspend fun saveExercise(exercise: Exercise): String {
        Log.d(ContentValues.TAG, "Request to save new exercise with id: ${exercise.id}")
        return trace(SAVE_TASK_TRACE) { exerciseCollection().add(exercise).await().id }
    }

    override suspend fun updateExercise(exercise: Exercise): Unit {
        Log.d(ContentValues.TAG, "Request to update exercise with id: ${exercise.id}")
        return trace(UPDATE_TASK_TRACE) { exerciseCollection().document(exercise.id).set(exercise).await() }
    }
    private fun exerciseCollection(): CollectionReference =
        firestore.collection(EXERCISE_COLLECTION)

    companion object {
        private const val EXERCISE_COLLECTION = "activities"
        private const val SAVE_TASK_TRACE = "saveTask"
        private const val UPDATE_TASK_TRACE = "updateTask"
    }
}