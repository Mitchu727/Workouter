package com.example.workouter.model.service.firebase_implementation

import android.content.ContentValues
import android.util.Log
import com.example.workouter.model.Training
import com.example.workouter.model.Exercise
import com.example.workouter.model.TrainingPart
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

    override suspend fun createNewTraining(training: Training): String {
        Log.d(ContentValues.TAG, "Request to create new training with id: ${training.id}")
        return trace(SAVE_TRAINING_TRACE) { trainingCollection().add(training).await().id}
    }

    override suspend fun getTraining(trainingId: String): Training? {
        Log.d(ContentValues.TAG, "Request to get training with id: $trainingId")
        return trainingCollection().document(trainingId).get().await().toObject()
    }

    override suspend fun saveTrainingPart(trainingPart: TrainingPart): String {
        Log.d(ContentValues.TAG, "Request to save training part with id: ${trainingPart.id} of exercise: ${trainingPart.exerciseId} under training: ${trainingPart.trainingId}")
        return trace(SAVE_TRAINING_PART_TRACE){ trainingPartCollection().add(trainingPart).await().id }
    }

    private fun exerciseCollection(): CollectionReference =
        firestore.collection(EXERCISE_COLLECTION)

    private fun trainingCollection(): CollectionReference =
        firestore.collection(TRAINING_COLLECTION)

    private fun trainingPartCollection(): CollectionReference =
        firestore.collection(TRAINING_PART_COLLECTION)

    companion object {
        private const val EXERCISE_COLLECTION = "activities"
        private const val SAVE_TASK_TRACE = "saveTask"
        private const val SAVE_TRAINING_TRACE = "saveTraining"
        private const val SAVE_TRAINING_PART_TRACE = "saveTrainingPart"
        private const val UPDATE_TASK_TRACE = "updateTask"
        private const val TRAINING_COLLECTION = "trainings"
        private const val TRAINING_PART_COLLECTION = "trainingParts"
    }
}