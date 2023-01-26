package com.example.workouter.model.service

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.workouter.model.Training

interface TrainingService {
    val currentTraining: MutableState<Training>
    suspend fun startNewTraining(): String
    suspend fun getCurrentTraining(): Training
}

class DefaultTrainingService(
    val storageService: StorageService
): TrainingService {
    override val currentTraining = mutableStateOf(Training())
    override suspend fun startNewTraining(): String {
        currentTraining.value = Training.createNew()
        val newTraining = currentTraining.value
        return storageService.createNewTraining(newTraining)
    }

    override suspend fun getCurrentTraining():Training {
        return currentTraining.value
    }
}

