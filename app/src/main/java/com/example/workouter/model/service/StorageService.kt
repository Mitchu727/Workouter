package com.example.workouter.model.service

import com.example.workouter.model.Training
import com.example.workouter.model.Exercise
import com.example.workouter.model.TrainingPart
import kotlinx.coroutines.flow.Flow

interface StorageService {
    val exercises: Flow<List<Exercise>>
    val trainingParts: Flow<List<TrainingPart>>
    suspend fun getAllExercises(): List<Exercise>
    suspend fun getExercise(exerciseId: String): Exercise?
    suspend fun saveExercise(exercise: Exercise): String
    suspend fun updateExercise(exercise: Exercise): Unit
    suspend fun createNewTraining(training: Training): String
    suspend fun getTraining(trainingId: String): Training?
    suspend fun saveTrainingPart(trainingPart: TrainingPart): String
    suspend fun getTrainingParts(exerciseId: String): List<TrainingPart>
}