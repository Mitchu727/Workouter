package com.example.workouter.model.service

import com.example.workouter.model.Training
import com.example.workouter.model.Exercise
import com.example.workouter.model.TrainingPart
import kotlinx.coroutines.flow.Flow

interface StorageService {
    val exercises: Flow<List<Exercise>>
    suspend fun getAllExercises(): List<Exercise>
    suspend fun getExercise(exerciseId: String): Exercise?
    suspend fun saveExercise(exercise: Exercise): String
    suspend fun updateExercise(exercise: Exercise): Unit
    suspend fun createNewTraining(newTraining: Training): String
    suspend fun getTraining(trainingId: String): Training?
    suspend fun saveTrainingPart(trainingPart: TrainingPart): String
}